package com.springbootmybatis.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class aopDemo {

    // annotation 
    @Pointcut("execution(* com.springbootmybatis.controller.*.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void before() {
        log.info("MyAspect before ...");
    }

    @After("pointCut()")
    public void after() {
        log.info("MyAspect after ...");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        log.info("MyAspect after returning ...");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        log.info("MyAspect after throwing ...");
    }


}
