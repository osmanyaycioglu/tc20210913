package com.training.spring;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
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
        Future<String> refreshLoc = this.refresh();
        System.out.println("Schedule test1");
        System.out.println("Schedule test2");
        System.out.println("Schedule test3");
        System.out.println("Schedule test4");
        System.out.println("Schedule test5");
        try {
            String stringLoc = refreshLoc.get();
            System.out.println(stringLoc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Async("myExecutor")
    public Future<String> refresh() {
        System.out.println("test1");
        System.out.println("test2");
        System.out.println("test3");
        System.out.println("test4");
        System.out.println("test5");
        return CompletableFuture.completedFuture("test finished");
    }
}
