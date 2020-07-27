package com.example.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value =@Queue,//创建临时队列
                    exchange = @Exchange(value = "topics",type = "topic"),//绑定的交换机
                    key = {"user.*"}
            )
    })
    public void accept(String message){
        System.out.println(message+"----1");
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value =@Queue,//创建临时队列
                    exchange = @Exchange(value = "topics",type = "topic"),//绑定的交换机
                    key = {"find.*"}
            )
    })
    public void accept1(String message){
        System.out.println(message+"----2");
    }
}
