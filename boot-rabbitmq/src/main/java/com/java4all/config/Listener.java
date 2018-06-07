package com.java4all.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.List;

@Configuration
@RabbitListener(queues = "send1")
public class Listener {

    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Bean
    public Queue send1Queue(){
        return new Queue("send1");
    }

    @RabbitHandler
    public void process(@Payload List<String> message) {
        // 处理业务逻辑,降低耦合
        for (String s : message) {
            LOGGER.info("*******************Listener:" + s +"****************************");
            try {
                Thread.sleep(5*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
