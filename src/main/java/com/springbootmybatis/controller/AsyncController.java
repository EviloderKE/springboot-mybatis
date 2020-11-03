package com.springbootmybatis.controller;

import com.springbootmybatis.service.impl.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("async")
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("test")
    public void test(){

        asyncService.test();

        System.out.println(1);
    }

    @GetMapping("sync")
    public void sync(){

        asyncService.test1();

        asyncService.test1();

    }

}
