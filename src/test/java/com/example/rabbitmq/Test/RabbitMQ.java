package com.example.rabbitmq.Test;

import com.example.rabbitmq.RabbitmqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RabbitmqApplication.class)
@RunWith(SpringRunner.class)
public class RabbitMQ {

    //注入rabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //hello world
    @Test
    public void test(){
        for (int i = 0; i < 10 ; i++) {
            rabbitTemplate.convertAndSend("hello","hello world");
        }
    }

    //fanout广播
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("logs","","交换机fault");
    }

    //direct路由模式
    @Test
    public void directTest(){
        rabbitTemplate.convertAndSend("directs","error","路由info");
    }

    //topic订阅模式
    @Test
    public void topicTest(){
        rabbitTemplate.convertAndSend("topics","user.info","topic订阅模式");
    }



}
