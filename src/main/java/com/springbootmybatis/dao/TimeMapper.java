package com.springbootmybatis.dao;

import com.springbootmybatis.domain.po.Time;
import com.springbootmybatis.domain.po.TimeDate;

public interface TimeMapper {

    int insertOne(Time time);

    int insertOneOld(TimeDate timedate);

}
