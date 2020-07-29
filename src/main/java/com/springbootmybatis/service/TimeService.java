package com.springbootmybatis.service;

import com.springbootmybatis.po.Time;
import com.springbootmybatis.po.TimeDate;

public interface TimeService {

    int insertOne(Time time);

    int insertOneOld(TimeDate timeDate);

}
