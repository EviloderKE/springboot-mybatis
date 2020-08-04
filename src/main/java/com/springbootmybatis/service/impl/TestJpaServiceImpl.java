package com.springbootmybatis.service.impl;

import com.springbootmybatis.dao.TestJpaMapper;
import com.springbootmybatis.po.TestJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestJpaServiceImpl {

    @Autowired
    TestJpaMapper testJpaMapper;

    public TestJpa findById(Long id){
        return testJpaMapper.findById(id).get();
    }
}
