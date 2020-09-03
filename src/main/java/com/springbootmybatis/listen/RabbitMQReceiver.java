package com.springbootmybatis.listen;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;


//@Component
public class RabbitMQReceiver {

    @RabbitListener(queues = "direct")
    @RabbitHandler
    public void processOne(String msg) {
        System.out.println("directReceiver: " + msg);
    }

    @RabbitListener(queues = "topic")
    @RabbitHandler
    public void processTwo(String msg) {
        System.out.println("topicReceiver: " + msg);
    }


    @RabbitListener(queues = "fanout")
    @RabbitHandler
    public void processThree(String msg) {
        System.out.println("fanoutMessageReceiver: " + msg);
    }

}
