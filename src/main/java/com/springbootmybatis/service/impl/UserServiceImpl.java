package com.springbootmybatis.service.impl;

import com.springbootmybatis.dao.UserMapper;
import com.springbootmybatis.po.User;
import com.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public User getUserInfo(Long id) {
        return userMapper.findUserWithAddress(id);
    }
}
