package com.example.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloConsumer {

    @RabbitListener(queuesToDeclare = @Queue(value = "hello",durable = "true",autoDelete = "false"))
    public void receive(String message){
        System.out.println(message+"1");
    }

    @RabbitListener(queuesToDeclare = @Queue(value = "hello",durable = "true",autoDelete = "false"))
    public void receive1(String message){
        System.out.println(message+"2");
    }


}
