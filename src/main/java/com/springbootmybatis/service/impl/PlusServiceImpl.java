package com.springbootmybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootmybatis.dao.TestMapper;
import com.springbootmybatis.po.Test;
import com.springbootmybatis.service.PlusService;
import org.springframework.stereotype.Service;

@Service
public class PlusServiceImpl extends ServiceImpl<TestMapper, Test> implements PlusService {


}
