package com.springbootmybatis.domain.qo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.springbootmybatis.excel.GenderConverter;
import lombok.Data;

@Data
public class UserExcel {

    private String name;

    private Integer age;

    /**
     * 性别 1：男；2：女
     */
    @ExcelProperty(converter = GenderConverter.class)
    private Integer gender;

    /**
     * 出生日期
     */
    @ExcelProperty(index = 3)
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private String birthday;

}
