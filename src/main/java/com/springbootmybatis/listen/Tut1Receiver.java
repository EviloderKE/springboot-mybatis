package com.springbootmybatis.listen;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;

import java.io.IOException;

@Profile("rabbitmq")
@RabbitListener(queues = "hello")
public class Tut1Receiver {

    @RabbitHandler
    public void receive(String in, Channel channel, Message message) throws IOException {

        System.out.println(" [x] Received '" + in + "'");

        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        System.out.println("消息已确认");
    }

}
