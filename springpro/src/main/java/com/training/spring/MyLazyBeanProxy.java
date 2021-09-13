package com.training.spring;

public class MyLazyBeanProxy extends MyLazyBean {


    private final MyLazyBean bean;

    public MyLazyBeanProxy(final MyLazyBean beanParam) {
        super(null);
        this.bean = beanParam;
    }

    @Override
    public String hello() {
        System.out.println("proxy before call");
        String helloLoc = this.bean.hello();
        System.out.println("proxy after call");
        return helloLoc + " from Proxy";
    }

}
