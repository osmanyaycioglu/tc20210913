package com.training.spring;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Startup1 implements CommandLineRunner {

    @Override
    public void run(final String... argsParam) throws Exception {
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


}
