package com.training.spring;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyStarter implements ApplicationRunner {

    @Autowired
    private MyCache  mc;

    @Autowired
    @Qualifier("myExecutor")
    private Executor exec;

    private boolean  initialized = false;

    @Override
    public void run(final ApplicationArguments argsParam) throws Exception {
        this.exec.execute(this::initialize);
    }

    private void initialize() {
        // Bütün ilk işler
        this.initialized = true;
    }

}
