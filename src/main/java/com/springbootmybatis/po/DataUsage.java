package com.springbootmybatis.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigInteger;

@TableName("m2m_datausage")
public class DataUsage {

    int id;

    String iccid;

    String iccid19;

    BigInteger sim;

    int yearmonth;

    @TableField("datausage_month")
    BigInteger dataUsageMonth;
}
