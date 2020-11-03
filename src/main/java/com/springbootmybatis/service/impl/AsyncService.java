package com.springbootmybatis.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AsyncService {

    @Async("asyncTaskExecutor")
    public void test(){

        log.info("线程开始");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("线程结束");
        System.out.println(2);
    }


    @Async("asyncTaskExecutor")
    public synchronized void test1(){
        for (int i = 0; i < 10; i++) {
            log.info("{}", i);
        }
    }

}
