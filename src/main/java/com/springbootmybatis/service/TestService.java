package com.springbootmybatis.service;

import com.springbootmybatis.po.Test;
import com.springbootmybatis.po.TestJpa;

import java.util.List;

public interface TestService {

    List<Test> getList();

    TestJpa addJpa(TestJpa testJpa);

    int addOneByPlus(Test test);
}
