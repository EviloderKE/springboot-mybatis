package com.springbootmybatis.controller;

import com.springbootmybatis.po.Test;
import com.springbootmybatis.service.PlusService;
import com.springbootmybatis.vo.result.FailResult;
import com.springbootmybatis.vo.result.Result;
import com.springbootmybatis.vo.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("plus")
@RestController
public class PlusController {

    @Autowired
    private PlusService plusService;

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

}
