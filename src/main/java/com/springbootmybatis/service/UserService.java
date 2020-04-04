package com.springbootmybatis.service;

import com.springbootmybatis.domain.User;

import java.util.List;

public interface UserService {

    int add(User user);

    User getUserInfo(Long id);

    List<User> getAllUserInfo();
}
