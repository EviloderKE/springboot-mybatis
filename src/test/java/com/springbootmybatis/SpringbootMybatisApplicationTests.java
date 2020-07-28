package com.springbootmybatis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class SpringbootMybatisApplicationTests {

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

    }

}
