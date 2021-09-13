package com.training.spring.rest;


public class ErrorObj {

    private String msg;
    private int    cause;

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(final String msgParam) {
        this.msg = msgParam;
    }

    public int getCause() {
        return this.cause;
    }

    public void setCause(final int causeParam) {
        this.cause = causeParam;
    }

}
