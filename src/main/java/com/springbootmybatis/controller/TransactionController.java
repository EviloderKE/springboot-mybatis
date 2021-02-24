package com.springbootmybatis.controller;

import com.springbootmybatis.domain.po.Time;
import com.springbootmybatis.service.impl.TimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("trans")
public class TransactionController {

    @Autowired
    private TimeServiceImpl timeService;

    @GetMapping("test")
    public void test(){

        Time t = new Time();
        t.setDate(LocalDate.now());
        t.setDatetime(LocalDateTime.now());

        timeService.insertOne(t);

    }

}
