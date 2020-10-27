package com.springbootmybatis.enums;

import lombok.Getter;

@Getter
public enum ApplicationEnum {

    SUCCESS("2000","业务执行成功"),

    NOT_SUPPORT_REQUEST("5000", "不支持的请求方法"),
    ERROR_POST_PARAM("4000", "访问参数异常"),

    PARAMETER_BIND_FAIL("4000","参数绑定失败"),
    PARAMETER_VERIFY_FAIL("4001","参数校验失败"),

    USER_NAME_REPETITION("4101","用户名已存在"),
    USER_OR_PWD_ERR("4102","用户名或密码错误"),
    NO_LOGIN("4103","未登陆"),
    YET_LOGIN("4104","已登陆"),
    USER_NO_EXIST("4105","用户不存在"),
    PASSWORD_ERR("4106","密码错误"),

    REQUEST_FREQUENTLY("4201","请求太过频繁"),

    TOKEN_INVALID("4301", "token失效"),


    FAIL("5000","业务执行失败");


    /**
     *
     * controller ：控制层
     * po : 存放与数据库中表相对应的java对象
     * dto : 存放数据传输对象，比如注册时，注册的信息可以用一个 dto 对象来接收
     * dao : 存放操作数据库的接口
     * service : 业务层
     * vo : 存放业务返回结果对象
     * qo : 封装了查询参数的对象
     *
     */

    /**
     * 设计原则
     * 2xxx 业务执行成功
     * 4xxx 由于用户导致的错误，比如注册时，重复注册导致的注册失败
     * 5xxx 由于系统原因导致的错误
     */
    private String code;

    private String message;

    ApplicationEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
