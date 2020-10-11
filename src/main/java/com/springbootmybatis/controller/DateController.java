package com.springbootmybatis.controller;

import cn.hutool.core.date.DateUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
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

    @GetMapping("/jdk8")
    public void localDate(){
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate localDate = LocalDate.of(2017, 1, 4);
        // 初始化一个日期：2017-01-04
        System.out.println(localDate);

        int year = localDate.getYear();
        // 年份：2017
        System.out.println(year);

        Month month = localDate.getMonth();
        // 月份：JANUARY
        System.out.println(month);

        int dayOfMonth = localDate.getDayOfMonth();
        // 月份中的第几天：4
        System.out.println(dayOfMonth);

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        // 一周的第几天：WEDNESDAY
        System.out.println(dayOfWeek);

        int length = localDate.lengthOfMonth();
        // 月份的天数：31
        System.out.println(length);

        boolean leapYear = localDate.isLeapYear();
        // 是否为闰年：false
        System.out.println(leapYear);

        LocalTime localTime = LocalTime.of(17, 23, 52);
        // 初始化一个时间：17:23:52
        System.out.println(localTime);

        int hour = localTime.getHour();
        // 时：17
        System.out.println(hour);

        int minute = localTime.getMinute();
        // 分：23
        System.out.println(minute);

        int second = localTime.getSecond();
        // 秒：52
        System.out.println(second);

        Long second1 = Instant.now().getEpochSecond();// 精确到秒
        System.out.println(second1);


        Long second2 = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(second2);

    }

    @GetMapping("/test")
    public void aa(){
        /*Date a = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String aa = simpleDateFormat.format(a);
        System.out.println(aa);

        Long b = 1602404126000L;
        Date bb = new Date(b);
        String bbb = simpleDateFormat.format(bb);
        System.out.println(bbb);

        long aaa = a.getTime();
        System.out.println(aaa);

        String c = "2020-10-11 16:21:30";
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date cc = simpleDateFormat1.parse(c);
            System.out.println(cc);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        LocalDate localDate = LocalDate.now();

        LocalDateTime localDateTime = LocalDateTime.now();

        LocalTime localTime = LocalTime.now();

        System.out.println(localDate);
        System.out.println(localDateTime);
        System.out.println(localTime);

        String a = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String b = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(a);
        System.out.println(b);

        // 获得秒时间戳
        long second = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).getEpochSecond();
        System.out.println(second);

        Long second1 = Instant.now().getEpochSecond();// 精确到秒
        System.out.println(second1);

        Long second2 = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(second2);

        // 毫秒
        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();



        // 将时间戳转为当前时间
        LocalDateTime localDateTimea = LocalDateTime.ofEpochSecond(second, 0, ZoneOffset.ofHours(8));


    }

}
