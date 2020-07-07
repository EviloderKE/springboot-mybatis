package com.springbootmybatis.controller;

import com.alibaba.fastjson.JSON;
import com.springbootmybatis.domain.Test;
import com.springbootmybatis.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public String test(){
        List<Test> list = testService.getList();

        return JSON.toJSONString(list);
    }

}
