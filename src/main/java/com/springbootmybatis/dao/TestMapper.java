package com.springbootmybatis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootmybatis.po.Test;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

public interface TestMapper extends BaseMapper<Test> {
}
