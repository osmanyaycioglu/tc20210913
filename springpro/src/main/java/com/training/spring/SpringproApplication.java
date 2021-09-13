package com.training.spring;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import a.b.c.A;

//@SpringBootApplication(scanBasePackages = {
//                                            "com.training.spring",
//                                            "a.b.c"
//})
@SpringBootApplication
@EnableScheduling
public class SpringproApplication {

    @Bean
    public Executor myExecutor() {
        return Executors.newFixedThreadPool(5);
    }

    @Autowired
    private A a;


    @Autowired
    private MyLazyBean lazyBean;

    public static void main(final String[] args) {
        MyLazyBean myLazyBeanLoc = new MyLazyBeanProxy(new MyLazyBean("Hello"));
        String helloLoc = myLazyBeanLoc.hello();
        System.out.println(helloLoc);

        SpringApplication.run(SpringproApplication.class,
                              args);
    }

}
