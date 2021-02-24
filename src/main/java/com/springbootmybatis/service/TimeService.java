package com.springbootmybatis.service;

import com.springbootmybatis.domain.po.Time;
import com.springbootmybatis.domain.po.TimeDate;

public interface TimeService {

    int insertOne(Time time);

    int insertOneOld(TimeDate timeDate);

}
