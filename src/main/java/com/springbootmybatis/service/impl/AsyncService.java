package com.springbootmybatis.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
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

    @Async("asyncTaskExecutor")
    public Future<String> returnValue(){
        log.info("线程开始");
        return new AsyncResult<>("aa");
    }

    @Async("asyncTaskExecutor")
    public Future<List<String>> returnValue2(){
        log.info("线程开始");

        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");

        return new AsyncResult<>(strings);
    }

}
