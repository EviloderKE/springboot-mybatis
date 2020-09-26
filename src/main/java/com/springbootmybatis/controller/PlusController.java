package com.springbootmybatis.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springbootmybatis.dao.DataUsageMapper;
import com.springbootmybatis.dao.TestMapper;
import com.springbootmybatis.po.DataUsage;
import com.springbootmybatis.po.Test;
import com.springbootmybatis.service.PlusService;
import com.springbootmybatis.vo.result.FailResult;
import com.springbootmybatis.vo.result.Result;
import com.springbootmybatis.vo.result.SuccessResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("plus")
@RestController
@Slf4j
public class PlusController {

    @Autowired
    private PlusService plusService;

    @Autowired
    DataUsageMapper dataUsageMapper;

    @Autowired
    TestMapper testMapper;

    @GetMapping("addBatch")
    public Result<Object> addBatch(){

        List<Test> lt = new ArrayList<>();

        Test t1 = new Test();
        t1.setName("t1");

        Test t2 = new Test();
        t2.setName("t2");

        lt.add(t1);
        lt.add(t2);

        boolean b = plusService.saveBatch(lt);

        if(b){
            return new SuccessResult<>();
        }else{
            return new FailResult<>();
        }
    }

    @GetMapping("addOneByPlus")
    public void addOneByPlus(){
        Test test = new Test();
        test.setName("plusOne");
        int a = plusService.addOneByPlus(test);
        log.info("插入结果:{}", a);
    }

    @GetMapping("search")
    public void search(){
        QueryWrapper<Test> qw1 = new QueryWrapper<>();
        qw1.eq("age", 1);
        Test t1 = plusService.getOne(qw1);
        log.info("等于1getOne:{}", JSON.toJSONString(t1));

        // 不能查询有多种情况
        /*QueryWrapper<Test> qw2 = new QueryWrapper<>();
        qw2.ge("age", 1);
        Test t2 = plusService.getOne(qw2);
        log.info("大于等于1getOne:{}", JSON.toJSONString(t2));*/

        QueryWrapper<Test> qw3 = new QueryWrapper<>();
        qw3.ge("age", 1);
        List<Test> t3 = plusService.list(qw3);
        log.info("大于等于1list:{}", JSON.toJSONString(t3));
    }

    @GetMapping("/test")
    public void test(){
        //List<DataUsage> dataUsages = dataUsageMapper.selectPage(null);

        Test test = new Test();
        test.setName("aaa");
        test.setAge(25);
        int a = testMapper.insert(test);

        System.out.println(a);
        System.out.println(test.getId());

        //System.out.println(dataUsages);
    }

}
