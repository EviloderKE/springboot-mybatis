package com.springbootmybatis.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class LogAspect {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Pointcut("execution(* com.springbootmybatis.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("========================================== Start ==========================================");
        // 打印请求 url
        log.info("URL: {}", request.getRequestURL().toString());
        // 打印描述信息
        // 打印 Http method
        log.info("HTTP Method: {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method: {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        log.info("IP: {}", request.getRemoteAddr());
        // 打印请求入参
        log.info("Request Args: {}", JSON.toJSONString(joinPoint.getArgs()));
    }

    @After("log()")
    public void doAfter() throws Throwable {
        // 接口结束后换行，方便分割查看
        log.info("=========================================== End ===========================================" + LINE_SEPARATOR);
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        // 打印出参
        log.info("Response Args: {}", JSON.toJSONString(result));
        // 执行耗时
        log.info("Time-Consuming: {} ms", System.currentTimeMillis() - startTime);
        return result;
    }

}
