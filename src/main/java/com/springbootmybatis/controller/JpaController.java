package com.springbootmybatis.controller;

import com.alibaba.fastjson.JSON;
import com.springbootmybatis.po.TestJpa;
import com.springbootmybatis.service.JpaService;
import com.springbootmybatis.service.impl.JpaServiceImpl;
import com.springbootmybatis.vo.result.FailResult;
import com.springbootmybatis.vo.result.Result;
import com.springbootmybatis.vo.result.SuccessResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jpa")
@Slf4j
public class JpaController {

    @Autowired
    private JpaService jpaService;

    @GetMapping("addJpa")
    public Result addJpa(){
        TestJpa testJpa = new TestJpa();
        testJpa.setName("jpa11");

        TestJpa test = jpaService.addJpa(testJpa);

        log.info("返回值:{}", test);
        log.info("返回值:{}", JSON.toJSONString(test));
        if(ObjectUtils.isEmpty(test)){
            return new FailResult<>();
        }else{
            return new SuccessResult<>();
        }

    }

    @GetMapping("getJpa")
    public void getJpa(){
        Long id = (long)2;
        TestJpa a = jpaService.findById(id);
        log.info("查询结果:{}", JSON.toJSONString(a));
    }


}
