package com.springbootmybatis.controller;

import cn.hutool.core.date.DateUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@RestController
@RequestMapping("/date")
public class DateController {

    @GetMapping("/date")
    public void date(){
        // 获取毫秒时间戳
        // long timestamp = System.currentTimeMillis();
        long timestamp = new Date().getTime();

        // 时间戳转date
        Date date = new Date(timestamp);
        System.out.println(date);

        // 字符串转date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parseDate = simpleDateFormat.parse("2020-10-13 21:01:00");
            System.out.println(parseDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 格式化date
        String dateString = simpleDateFormat.format(date);
        System.out.println(dateString);
    }

    @GetMapping("localdatetime")
    public void localDateTime(){
        // 获取秒时间戳
        long second = LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(8));
        long second1 = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        long second2 = Instant.now().getEpochSecond();
        System.out.println(second);
        System.out.println(second2);

        // 毫秒
        long milliSecond = Instant.now().toEpochMilli();

        // 时间戳转LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(second, 0, ZoneOffset.of("+8"));
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(Instant.ofEpochSecond(second1), ZoneId.systemDefault());
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(Instant.ofEpochSecond(second1), TimeZone.getDefault().toZoneId());
        System.out.println(localDateTime);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);

        // 字符串转localDateTime
        LocalDateTime date = LocalDateTime.parse("2020-10-13 21:01:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(date);

        // 格式化
        String dateStr = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(dateStr);

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
