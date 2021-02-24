package com.springbootmybatis.controller;

import com.alibaba.fastjson.JSON;
import com.springbootmybatis.domain.po.User;
import com.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserInfo")
    public String getUserInfo(String id){
        User user = userService.getUserInfo(Long.valueOf(id));

        return JSON.toJSONString(user);
    }
}
