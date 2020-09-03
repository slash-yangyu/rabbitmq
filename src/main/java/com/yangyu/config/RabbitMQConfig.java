package com.yangyu.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;


public class RabbitMQConfig  {
    @Bean
    public Queue queue(){
        return new Queue("orders");
    }

}
