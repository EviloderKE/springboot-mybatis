package com.springbootmybatis.service.impl;

import com.springbootmybatis.dao.UserMapper;
import com.springbootmybatis.domain.User;
import com.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<User> getAllUserInfo() {
        return userMapper.getAllUserInfo();
    }

    @Override
    public User getUserCar(Long id) {
        return userMapper.getUserWithCar(id);
    }
}
