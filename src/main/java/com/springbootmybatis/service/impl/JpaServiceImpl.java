package com.springbootmybatis.service.impl;

import com.springbootmybatis.dao.TestJpaMapper;
import com.springbootmybatis.po.TestJpa;
import com.springbootmybatis.service.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaServiceImpl implements JpaService {

    @Autowired
    private TestJpaMapper testJpaMapper;

    public TestJpa findById(Long id){
        return testJpaMapper.findById(id).get();
    }

    public TestJpa addJpa(TestJpa testJpa) {
        return testJpaMapper.save(testJpa);
    }
}
