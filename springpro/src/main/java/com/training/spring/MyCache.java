package com.training.spring;

import java.util.concurrent.Executor;

import org.springframework.scheduling.annotation.Scheduled;

public class MyCache {


    private final MyLazyBean lazyBean;

    private final Executor   exec;

    public MyCache(final MyLazyBean lazyBean,
                   final Executor exec) {
        this.lazyBean = lazyBean;
        this.exec = exec;
        this.exec.execute(() -> System.out.print("running"));
    }

    @Scheduled(initialDelay = 100, fixedDelay = 3600000)
    public void cacheRefresh() {
        //Cache
    }
}
