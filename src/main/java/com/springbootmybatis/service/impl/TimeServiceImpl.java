package com.springbootmybatis.service.impl;

import com.springbootmybatis.dao.TimeMapper;
import com.springbootmybatis.po.Time;
import com.springbootmybatis.po.TimeDate;
import com.springbootmybatis.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    private TimeMapper timeMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertOne(Time time) {
        timeMapper.insertOne(time);

        return 10/0;
    }

    @Override
    public int insertOneOld(TimeDate timeDate) {
        return timeMapper.insertOneOld(timeDate);
    }
}
