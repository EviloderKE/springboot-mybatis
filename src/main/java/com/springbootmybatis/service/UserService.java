package com.springbootmybatis.service;

import com.springbootmybatis.domain.User;

public interface UserService {

    int add(User user);

    User getUserInfo(Long id);

}
