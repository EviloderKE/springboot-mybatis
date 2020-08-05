package com.springbootmybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootmybatis.po.Test;

public interface PlusService extends IService<Test> {

    int addOneByPlus(Test test);
}
