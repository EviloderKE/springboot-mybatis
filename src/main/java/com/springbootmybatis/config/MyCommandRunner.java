package com.springbootmybatis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyCommandRunner implements CommandLineRunner {
    @Override
    public void run(String... args) {
        log.info("CommandLineRunner");
    }
}
