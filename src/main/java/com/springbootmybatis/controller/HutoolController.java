package com.springbootmybatis.controller;

import cn.hutool.core.util.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hutool")
@Slf4j
public class HutoolController {

    @GetMapping("checkInt")
    public Boolean checkInt(){
        String a = "001";

        Integer b = Integer.valueOf(a);
        log.info("a转b:{}", b);

        return NumberUtil.isInteger(a);
    }

}
