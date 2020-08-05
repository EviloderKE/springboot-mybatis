package com.springbootmybatis.service;

import com.springbootmybatis.po.TestJpa;

public interface JpaService {
    TestJpa findById(Long id);

    TestJpa addJpa(TestJpa testJpa);
}
