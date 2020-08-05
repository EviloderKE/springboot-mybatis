package com.springbootmybatis;

import com.springbootmybatis.po.TestJpa;
import com.springbootmybatis.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    TestService testService;

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
        List<String> a = new ArrayList<>();

        String dataA[] = {"a", "b", "c"};

        Collections.addAll(a, dataA);

        List<String> b = new ArrayList<>();

        String dataB[] = {"a", "d"};

        Collections.addAll(b, dataB);

        List<String> res = a.stream().filter(s -> !b.contains(s)).collect(Collectors.toList());

        System.out.println(res);

        String url = "http://www.m2m.com/Api/Recharge/test";
        String result = new RestTemplate().getForObject(url, String.class);

    }

    @Test
    void test1(){
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

        Date now = new Date();
        System.out.println(now);
    }

}
