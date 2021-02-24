package com.springbootmybatis.domain.result;


import com.springbootmybatis.enums.ApplicationEnum;

public class ErrorResult<T> extends Result<T> {

    private static final long serialVersionUID = -6073157176763840816L;

    public ErrorResult() {
        setStatus(false);
        setCode(ApplicationEnum.FAIL.getCode());
        setMsg(ApplicationEnum.FAIL.getMessage());
    }
    
    public ErrorResult(ApplicationEnum applicationEnum) {
        setStatus(false);
        setCode(applicationEnum.getCode());
        setMsg(applicationEnum.getMessage());
    }


    public ErrorResult(ApplicationEnum applicationEnum, T data) {
        setStatus(false);
        setCode(applicationEnum.getCode());
        setMsg(applicationEnum.getMessage());
        setData(data);
    }



}
