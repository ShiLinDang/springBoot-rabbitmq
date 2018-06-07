package com.java4all.component;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Sender {

     @Autowired
     private RabbitTemplate rabbitTemplate;

     public void send(List<String> msg){
          this.rabbitTemplate.convertAndSend("send1",msg);
     }
}
