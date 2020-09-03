package com.yangyu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMQApplication.class)
public class TestRabbitMQ {

        @Resource
        private AmqpTemplate amqpTemplate;


        @Test
        public void order() throws Exception{
            String msg = "Order";
            System.out.println(msg+"发消息");
            this.amqpTemplate.convertAndSend("spring.test.order","order",msg);
            Thread.sleep(1000);
        }

        @Test
        public void logistics() throws Exception{
            String msg = "logistics";
            System.out.println(msg+"发消息");
            this.amqpTemplate.convertAndSend("spring.test.logistics","logistics",msg);
            Thread.sleep(1000);
        }

}
