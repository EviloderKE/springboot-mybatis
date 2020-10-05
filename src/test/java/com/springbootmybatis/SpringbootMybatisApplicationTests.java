package com.springbootmybatis;

import com.springbootmybatis.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

@ActiveProfiles("dev")
@SpringBootTest
@Slf4j
class SpringbootMybatisApplicationTests {

    @Autowired
    TestService testService;

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
        List<String> a = new ArrayList<>();

        String dataA[] = {"a", "b", "c"};

        Collections.addAll(a, dataA);

        List<String> b = new ArrayList<>();

        String dataB[] = {"a", "d"};

        Collections.addAll(b, dataB);

        List<String> res = a.stream().filter(s -> !b.contains(s)).collect(Collectors.toList());

        System.out.println(res);

        String url = "http://www.m2m.com/Api/Recharge/test";
        String result = new RestTemplate().getForObject(url, String.class);

    }

    @Test
    void test1(){

    }

    @Test
    void test2(){

        boolean b1 = StringUtils.isBlank("    ");
        log.info("{}", b1);  // true

        boolean b2 = StringUtils.isEmpty("    ");
        log.info("{}", b2);   // false

    }

    @Test
    void sum(){
        float a = 0.55f;

        float b = 0.3f;

        System.out.println(a * b);

        System.out.println (0.4 * 0.2);

        BigDecimal aa = new BigDecimal("0.4");
        BigDecimal bb = new BigDecimal("0.2");
        System.out.println (aa.multiply(bb));
    }

}
