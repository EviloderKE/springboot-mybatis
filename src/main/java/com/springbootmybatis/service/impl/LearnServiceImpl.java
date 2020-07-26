package com.springbootmybatis.service.impl;

import com.springbootmybatis.dao.LearnMapper;
import com.springbootmybatis.enums.ApplicationEnum;
import com.springbootmybatis.exception.ApplicationException;
import com.springbootmybatis.po.LearnResource;
import com.springbootmybatis.service.LearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LearnServiceImpl implements LearnService {

    @Autowired
    private LearnMapper learnMapper;

    @Override
    public int add(LearnResource learnResource) {
        return learnMapper.add(learnResource);
    }

    @Override
    public int update(LearnResource learnResource) {
        return learnMapper.update(learnResource);
    }

    @Override
    public int deleteById(String id) {
        return learnMapper.deleteById(id);
    }

    @Override
    public int deleteByIds(String ids) {
        return learnMapper.deleteByIds(ids);
    }

    @Override
    public LearnResource queryById(Long id) {
        return learnMapper.queryById(id);
    }

    @Override
    public List<LearnResource> queryLearnResourceList() {
        return learnMapper.queryLearnResourceList();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int insertOne(LearnResource learnResource) {

        int res = learnMapper.addOne(learnResource);
        if(res > 0){
            throw new ApplicationException(ApplicationEnum.REQUEST_FREQUENTLY);
        }

        return res;
    }

}
