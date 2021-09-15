package com.training.spring;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.training.spring.employeep.Employee;

//@SpringBootApplication(scanBasePackages = {
//                                            "com.training.spring",
//                                            "a.b.c"
//})
@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories
@EnableTransactionManagement
@EnableAsync
@EnableAspectJAutoProxy
@EnableRabbit
public class SpringproApplication {

    @Bean("threadPoolTaskExecutor")
    public TaskExecutor getAsyncExecutor() {
        System.out.println("---------------------------------- task executor -------------------");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(1000);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadNamePrefix("Async-");
        return executor;
    }

    @Bean
    public Executor myExecutor() {
        return Executors.newFixedThreadPool(5);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Autowired
    RabbitTemplate rt;

    Random         randomLoc = new SecureRandom();

    @Scheduled(fixedDelay = 500)
    public void sendMessages() {
        int nextIntLoc = this.randomLoc.nextInt();
        this.rt.convertAndSend("root_exchange",
                               ((nextIntLoc % 2) == 0) ? "secondary_message" : "root_message",
                               "message " + nextIntLoc);
        Employee employeeLoc = new Employee();
        employeeLoc.setName("osman" + nextIntLoc);
        employeeLoc.setSurname("test");
        employeeLoc.setVers(nextIntLoc);
        this.rt.convertAndSend("employee_exchange",
                               ((nextIntLoc % 2) == 0) ? "emp.tr.id" + nextIntLoc : "emp.eu.id" + nextIntLoc,
                               employeeLoc);
    }

    //    @Autowired
    //    private A          a;
    //
    //    @Autowired
    //    private MyLazyBean lazyBean;

    //    @Autowired
    //    private Startup1 s;

    //    public void name() {
    //        CompletableFuture<String> refreshLoc = this.s.refresh();
    //        CompletableFuture<String> refreshLoc2 = this.s.refresh2();
    //        CompletableFuture<String> refreshLoc3 = this.s.refresh3();
    //        System.out.println("deneme1");
    //        System.out.println("deneme2");
    //        System.out.println("deneme3");
    //        System.out.println("deneme4");
    //        System.out.println("deneme5");
    //        CompletableFuture.allOf(refreshLoc,
    //                                refreshLoc2,
    //                                refreshLoc3)
    //                         .join();
    //        try {
    //            System.out.println(refreshLoc.get());
    //            System.out.println(refreshLoc2.get());
    //            System.out.println(refreshLoc3.get());
    //        } catch (InterruptedException | ExecutionException e) {
    //            e.printStackTrace();
    //        }
    //    }


    public static void main(final String[] args) {
        MyLazyBean myLazyBeanLoc = new MyLazyBeanProxy(new MyLazyBean("Hello"));
        String helloLoc = myLazyBeanLoc.hello();
        System.out.println(helloLoc);

        SpringApplication.run(SpringproApplication.class,
                              args);
    }

}
