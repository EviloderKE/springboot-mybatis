package com.springbootmybatis.controller;

import com.springbootmybatis.util.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisOperator redisOperator;

    @GetMapping("/set")
    public void set(){
        redisOperator.set("name", "zk");
    }

    @GetMapping("/get")
    public Object get(){
        return redisOperator.get("name");
    }

}
