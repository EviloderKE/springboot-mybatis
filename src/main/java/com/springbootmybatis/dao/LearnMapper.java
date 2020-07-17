package com.springbootmybatis.dao;

import com.springbootmybatis.po.LearnResource;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface LearnMapper {
    int add(LearnResource learnResource);

    int update(LearnResource learnResource);

    LearnResource queryById(@Param("id") Long id);

    int deleteById(String id);

    int deleteByIds(@Param("ids") String ids);

    List<LearnResource> queryLearnResourceList();
}
