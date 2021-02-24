package com.springbootmybatis.service;

import com.springbootmybatis.domain.po.TestJpa;

public interface JpaService {
    TestJpa findById(Long id);

    TestJpa addJpa(TestJpa testJpa);
}
