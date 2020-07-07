package com.springbootmybatis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootmybatis.domain.Test;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TestMapper extends BaseMapper<Test> {
}
