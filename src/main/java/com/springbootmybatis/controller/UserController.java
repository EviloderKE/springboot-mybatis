package com.springbootmybatis.controller;

import com.alibaba.fastjson.JSON;
import com.springbootmybatis.domain.User;
import com.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo")
    public String getUserInfo(String id){
        User user = userService.getUserInfo(Long.valueOf(id));

        String jsonOutput= JSON.toJSONString(user);
        return jsonOutput;
    }
}
