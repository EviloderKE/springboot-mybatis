package com.springbootmybatis.service.impl;

import com.springbootmybatis.dao.TimeMapper;
import com.springbootmybatis.po.Time;
import com.springbootmybatis.po.TimeDate;
import com.springbootmybatis.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    private TimeMapper timeMapper;

    @Override
    public int insertOne(Time time) {
        return timeMapper.insertOne(time);
    }

    @Override
    public int insertOneOld(TimeDate timeDate) {
        return timeMapper.insertOneOld(timeDate);
    }
}
