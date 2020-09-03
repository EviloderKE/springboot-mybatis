package com.springbootmybatis.dao;

import com.springbootmybatis.po.TestJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 *  Skipping MapperFactoryBean with name 'testJpaMapper' and 'com.springbootmybatis.dao.TestJpaMapper' mapperInterface. Bean already defined with the same name!
 *
 *  去掉mapperScan?
 */
public interface TestJpaMapper extends JpaRepository<TestJpa, Long> {
}
