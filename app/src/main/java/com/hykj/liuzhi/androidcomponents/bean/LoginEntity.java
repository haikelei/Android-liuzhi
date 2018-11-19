package com.hykj.liuzhi.androidcomponents.bean;

public class LoginEntity {
    private int code;
    private String msg;
    private int error;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "LoginEntity{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", error=" + error +
                '}';
    }
}
