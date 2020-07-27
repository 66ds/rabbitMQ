package com.example.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FaultConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value =@Queue,//创建临时队列
                    exchange = @Exchange(value = "logs",type = "fanout")//绑定的交换机
            )
    })
    public void accept(String message){
        System.out.println(message+"----1");
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value =@Queue,//创建临时队列
                    exchange = @Exchange(value = "logs",type = "fanout")//绑定的交换机
            )
    })
    public void accept1(String message){
        System.out.println(message+"----2");
    }
}
