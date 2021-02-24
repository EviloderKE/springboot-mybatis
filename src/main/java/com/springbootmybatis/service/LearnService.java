package com.springbootmybatis.service;

import com.springbootmybatis.domain.po.LearnResource;

import java.util.List;

public interface LearnService {

    int add(LearnResource learnResource);

    int update(LearnResource learnResource);

    int deleteById(String id);

    int deleteByIds(String ids);

    LearnResource queryById(Long id);

    List<LearnResource> queryLearnResourceList();

    int insertOne(LearnResource learnResource);
}
