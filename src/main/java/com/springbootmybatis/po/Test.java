package com.springbootmybatis.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Test {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String name;

    int age;
}
