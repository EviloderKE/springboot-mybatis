package com.springbootmybatis.controller;

import com.alibaba.fastjson.JSON;
import com.springbootmybatis.po.*;
import com.springbootmybatis.service.LearnService;
import com.springbootmybatis.service.TestService;
import com.springbootmybatis.service.TimeService;
import com.springbootmybatis.vo.result.ErrorResult;
import com.springbootmybatis.vo.result.Result;
import com.springbootmybatis.vo.result.SuccessResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test")
@Validated
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
            return new ErrorResult<>();
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
            return new ErrorResult<>();
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
            return new ErrorResult<>();
        }
    }

    @GetMapping("aa/{id}")
    public void aa(@PathVariable() @Min(1) int id){
        log.info("id:{}", id);
    }

}
