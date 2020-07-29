package com.springbootmybatis.dao;

import com.springbootmybatis.po.Time;
import com.springbootmybatis.po.TimeDate;

public interface TimeMapper {

    int insertOne(Time time);

    int insertOneOld(TimeDate timedate);

}
