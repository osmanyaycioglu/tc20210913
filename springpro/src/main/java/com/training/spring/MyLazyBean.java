package com.training.spring;

public class MyLazyBean {

    private final String str;


    public MyLazyBean(final String strParam) {
        super();
        this.str = strParam;
    }


    public String hello() {
        return this.str;
    }

}
