package com.training.spring;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.boot.ApplicationArguments;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class Startup1 {


    public void run(final ApplicationArguments argsParam) throws Exception {
        System.out.println("Starting async");
        Future<String> refreshLoc = this.refresh();
        System.out.println("test1");
        System.out.println("test2");
        System.out.println("test3");
        System.out.println("test4");
        System.out.println("test5");

        String stringLoc = refreshLoc.get();
        System.out.println(stringLoc);

    }


    @Async("threadPoolTaskExecutor")
    public CompletableFuture<String> refresh() {
        System.out.println("test1");
        System.out.println("test2");
        System.out.println("test3");
        System.out.println("test4");
        System.out.println("test5");
        return CompletableFuture.completedFuture("test finished");
    }


    @Async("threadPoolTaskExecutor")
    public CompletableFuture<String> refresh2() {
        System.out.println("A test1");
        System.out.println("A test2");
        System.out.println("A test3");
        System.out.println("A test4");
        System.out.println("A test5");
        return CompletableFuture.completedFuture("test finished");
    }

    @Async("myExecutor")
    public CompletableFuture<String> refresh3() {
        System.out.println("B test1");
        System.out.println("B test2");
        System.out.println("B test3");
        System.out.println("B test4");
        System.out.println("B test5");
        return CompletableFuture.completedFuture("test finished");
    }

}
