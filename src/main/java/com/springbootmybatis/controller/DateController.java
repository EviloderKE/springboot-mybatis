package com.springbootmybatis.controller;

import cn.hutool.core.date.DateUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/date")
public class DateController {

    @GetMapping("/utildate")
    public void utilDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String a = simpleDateFormat.format(date);
        System.out.println(a);

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String b = "2020-10-05 20:28:34";
        try {
            Date bb = simpleDateFormat1.parse(b);
            System.out.println(bb);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 获取时间戳
        Long time = new Date().getTime();
        System.out.println(time);

        System.out.println(System.currentTimeMillis());
    }

    @GetMapping("/dateutil")
    public void dateUtil(){
        //当前时间 格式：yyyy-MM-dd HH:mm:ss
        Date date = DateUtil.date();
        System.out.println(date);

        //当前时间 格式：yyyy-MM-dd HH:mm:ss
        Date date2 = DateUtil.date(Calendar.getInstance());
        System.out.println(date2);

        //当前时间 格式：yyyy-MM-dd HH:mm:ss
        Date date3 = DateUtil.date(System.currentTimeMillis());
        System.out.println(date3);

        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        System.out.println(now);

        //当前日期字符串，格式：yyyy-MM-dd
        String today= DateUtil.today();
        System.out.println(today);
    }

}
