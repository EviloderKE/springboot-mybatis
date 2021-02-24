package com.springbootmybatis.handler;

import com.springbootmybatis.enums.ApplicationEnum;
import com.springbootmybatis.exception.ApplicationException;
import com.springbootmybatis.domain.result.ErrorResult;
import com.springbootmybatis.domain.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统一异常处理
 * 如果一个异常能匹配多个 @ExceptionHandler 时，选择匹配深度最小的Exception(即最匹配的Exception)
 */
@Slf4j
@RestControllerAdvice
public class ApplicationExceptionHandler{

    /**
     * 处理自定义 ApplicationException 异常
     * ExceptionHandler 用于指定异常的类型
     * ResponseStatus 用于指定http的返回状态
     *
     * @param e
     * @return
     */
    @ExceptionHandler({ApplicationException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleApplicationException(ApplicationException e) {
        log.error("自定义异常", e);
        return new ErrorResult<>(e.getApplicationEnum());
    }

    /**
     * 其他异常的处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleRuntimeException(Exception e) {
        log.error("程序出错", e);
        return new ErrorResult<>();
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result methodNotSupportHandle(HttpRequestMethodNotSupportedException e) {
        log.error("不支持的请求方法", e);
        return new ErrorResult<>(ApplicationEnum.NOT_SUPPORT_REQUEST);
    }


    /**
     * 普通参数(非 java bean)校验出错时抛出 ConstraintViolationException 异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleConstraintViolationException(ConstraintViolationException e) {
        log.error("参数校验失败", e);
        List<Map<String, String>> list = new ArrayList<>();
        // e.getMessage() 的格式为 getUser.id: id不能为空, getUser.name: name不能为空
        String[] msgs = e.getMessage().split(", ");
        for(String msg : msgs){
            String[] fieldAndMsg = msg.split(": ");
            String field = fieldAndMsg[0].split("\\.")[1];
            String message = fieldAndMsg[1];

            Map<String, String> map = new HashMap<>(2);
            map.put("field", field);
            map.put("message", message);
            list.add(map);
        }
        return new ErrorResult<>(ApplicationEnum.PARAMETER_BIND_FAIL, list);
    }

    /**
     * 表单绑定到 java bean 出错时抛出 BindException 异常
     *
     * @return
     */
    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleBindException(BindException e) {
        log.error("参数绑定失败", e);
        List<Map<String, String>> list = getFieldAndMessage(e.getAllErrors());
        return new ErrorResult<>(ApplicationEnum.PARAMETER_BIND_FAIL, list);
    }

    /**
     * 请求体不传
     * @param e
     * @return
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
        log.error("请求体参数为空", e);
        return new ErrorResult(ApplicationEnum.ERROR_POST_PARAM);
    }


    /**
     * 将请求体解析并绑定到 java bean 时，如果出错，则抛出 MethodArgumentNotValidException 异常
     *
     * @return
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected Result handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        log.error("请求体绑定失败", e);
        List<Map<String, String>> list = getFieldAndMessage(e.getBindingResult().getAllErrors());
        return new ErrorResult<>(ApplicationEnum.PARAMETER_BIND_FAIL, list);

    }


    /**
     * 将 ObjectError 转换成 FieldError 并取出其中的 Field 和 Message
     *
     * @param objectErrorList
     * @return
     */
    private List<Map<String, String>> getFieldAndMessage(List<ObjectError> objectErrorList) {
        List<Map<String, String>> list = new ArrayList<>();
        for (ObjectError objectError : objectErrorList) {
            Map<String, String> map = new HashMap<>(2);
            if (objectError instanceof FieldError) {
                FieldError fieldError = (FieldError) objectError;
                map.put("field", fieldError.getField());
                map.put("message", fieldError.getDefaultMessage());
            } else {
                map.put("field", objectError.getObjectName());
                map.put("message", objectError.getDefaultMessage());
            }
            list.add(map);
        }
        return list;
    }
}
