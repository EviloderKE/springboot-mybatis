package com.springbootmybatis.controller;

import com.alibaba.fastjson.JSON;
import com.springbootmybatis.domain.User;
import com.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo")
    public String getUserInfo(String id){
        User user = userService.getUserInfo(Long.valueOf(id));
        System.out.println(user.getAddress());
        System.out.println(user.getAddressId());
        return JSON.toJSONString(user);
    }

    @RequestMapping("/getAllUserInfo")
    public String getAllUserInfo(){
        List<User> userList = userService.getAllUserInfo();
        for (User user : userList){
            System.out.println(user);
            System.out.println(user.getAddress());
        }

        return "1";
    }

    @RequestMapping("/getUserCar")
    public String getUserCar(String id){
        User user = userService.getUserCar(Long.valueOf(id));

        return JSON.toJSONString(user);
    }
}
