package com.springbootmybatis.service;

import com.springbootmybatis.domain.LearnResource;

public interface LearnService {

    int add(LearnResource learnResource);

    int update(LearnResource learnResource);

    int deleteById(String id);

    int deleteByIds(String ids);

    LearnResource queryById(Long id);


}
