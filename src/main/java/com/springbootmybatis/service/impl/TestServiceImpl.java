package com.springbootmybatis.service.impl;

import com.springbootmybatis.dao.TestJpaMapper;
import com.springbootmybatis.dao.TestMapper;
import com.springbootmybatis.po.Test;
import com.springbootmybatis.po.TestJpa;
import com.springbootmybatis.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private TestJpaMapper testJpaMapper;

    @Override
    public List<Test> getList() {
        return testMapper.selectList(null);
    }

    @Override
    public TestJpa addJpa(TestJpa testJpa) {
        return testJpaMapper.save(testJpa);
    }

    public int addOneByPlus(Test test){
        return testMapper.insert(test);
    }
}
