package com.springbootmybatis.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rabbitPublisher")
public class RabbitMQPublisherController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("sendEmail1")
    public String sendEmail1() {
        rabbitTemplate.convertAndSend("demo.fanout", "", "welcome to regist lytw13'blog!");
        return "success";
    }

    @GetMapping("sendEmail2")
    public String sendEmail2() {
        rabbitTemplate.convertAndSend("demo.direct", "zk", "welcome to regist lytw13'blog!");
        return "success";
    }

    @GetMapping("sendEmail3")
    public String sendEmail3() {
        rabbitTemplate.convertAndSend("demo.topic", "zk.hello", "welcome to regist lytw13'blog!");
        return "success";
    }

}
