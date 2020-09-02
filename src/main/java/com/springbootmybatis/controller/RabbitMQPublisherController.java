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

        rabbitTemplate.convertAndSend("demo.direct", "direct", "demo.direct message");

        rabbitTemplate.convertAndSend("demo.fanout", "", "demo.fanout message");

        rabbitTemplate.convertAndSend("demo.topic", "topic.test", "demo.topic message");

        return "success";
    }

}
