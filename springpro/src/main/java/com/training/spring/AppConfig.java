package com.training.spring;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import a.b.c.AConfig;

@Configuration
@Profile("live")
@Import(AConfig.class)
@PropertySource("classpath:my.properties")
public class AppConfig {

    @Bean
    public MyCache mcache(@Qualifier("myExecutor") final Executor exec) {
        return new MyCache(this.mLazyBean(),
                           exec);
    }

    @Bean
    @Lazy
    public MyLazyBean mLazyBean() {
        return new MyLazyBean("Hello");
    }

    @Bean
    public MyProp mProp() {
        return new MyProp();
    }

}
