package com.springbootmybatis.controller;

import com.alibaba.fastjson.JSON;
import com.springbootmybatis.po.LearnResource;
import com.springbootmybatis.po.Test;
import com.springbootmybatis.po.Time;
import com.springbootmybatis.po.TimeDate;
import com.springbootmybatis.service.LearnService;
import com.springbootmybatis.service.TestService;
import com.springbootmybatis.service.TimeService;
import com.springbootmybatis.vo.result.FailResult;
import com.springbootmybatis.vo.result.Result;
import com.springbootmybatis.vo.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private LearnService learnService;

    @Autowired
    private TimeService timeService;

    @RequestMapping("/test")
    public String test(){
        List<Test> list = testService.getList();

        return JSON.toJSONString(list);
    }

    @PostMapping("trans")
    public Result testTrans() {
        LearnResource learnResource = new LearnResource();
        learnResource.setAuthor("trans");
        learnResource.setTitle("trans");
        learnResource.setUrl("trans");

        if(learnService.insertOne(learnResource) > 0){
            return new SuccessResult<>();
        }else{
            return new FailResult<>();
        }
    }

    @GetMapping("addTime")
    public Result addTime(){

        Time t = new Time();
        t.setDate(LocalDate.now());
        t.setDatetime(LocalDateTime.now());

        int res = timeService.insertOne(t);

        if(res > 0){
            return new SuccessResult<>();
        }else{
            return new FailResult<>();
        }
    }

    @GetMapping("addTimeOld")
    public Result addTimeOld(){

        TimeDate t = new TimeDate();
        t.setDate(new Date());
        t.setDatetime(new Date());

        int res = timeService.insertOneOld(t);

        if(res > 0){
            return new SuccessResult<>();
        }else{
            return new FailResult<>();
        }
    }



}
