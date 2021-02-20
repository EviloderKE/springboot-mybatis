package com.springbootmybatis.controller;

import com.springbootmybatis.service.impl.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RequestMapping("async")
@RestController
@Slf4j
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("test")
    public void test(){

        asyncService.test();

        System.out.println(1);
    }

    @GetMapping("async")
    public void sync(){

        asyncService.test1();

        asyncService.test1();

    }

    @GetMapping("future")
    public void future(){

        log.info("进入方法");
        Future<String> stringFuture = asyncService.returnValue();

        // 不需要while
        try {
            System.out.println(stringFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        /*while (true) {
            if(stringFuture.isCancelled()){
                log.info("deal async task is Cancelled");
                break;
            }
            if (stringFuture.isDone() ) {
                log.info("deal async task is Done");
                try {
                    log.info("return result is " + stringFuture.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                break;
            }
            log.info("wait async task to end ...");
        }*/


    }

}
