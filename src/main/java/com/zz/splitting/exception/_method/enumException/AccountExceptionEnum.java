package com.zz.splitting.exception._method.enumException;


public enum AccountExceptionEnum {

    ACCOUNT_ALREADY_EXIST(301, "账户已存在"),
    ACCOUNT_WRONG_INFO(302, "账户信息有误");

    private Integer code;
    private String msg;

    AccountExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}


