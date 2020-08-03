package com.springbootmybatis.dao;

import com.springbootmybatis.po.TestJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestJpaMapper extends JpaRepository<TestJpa, Long> {
}
