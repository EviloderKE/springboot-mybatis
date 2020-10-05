package com.springbootmybatis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/date")
public class DateController {

    @GetMapping("/utilDate")
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
    }

}
