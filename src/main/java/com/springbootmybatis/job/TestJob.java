package com.springbootmybatis.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestJob {

    /**
     * 每2s
     */
    //@Scheduled(fixedRate = 2000)
    public void doSomething() {
        System.out.println("do something");
    }

}
