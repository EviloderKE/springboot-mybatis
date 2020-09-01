package com.springbootmybatis.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitConsumer")
@RabbitListener
public class RabbitMQConsumerController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("receiveEmail1")
    public void receiveEmail1() {

        Message receive = rabbitTemplate.receive("zk");

        System.out.println(JSON.toJSONString(receive));
    }

}
