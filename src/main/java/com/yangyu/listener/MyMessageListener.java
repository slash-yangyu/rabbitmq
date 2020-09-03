package com.yangyu.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;



@Component
public class MyMessageListener {


    public MyMessageListener(){
    }
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "logistics.to.order",durable = "true"),
            exchange = @Exchange(value = "spring.exchange.logistics",ignoreDeclarationExceptions = "true"),
            key = "logistics"))
    public  void order(String msg){
        System.out.println("order接收到消息："+msg);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "logistics.to.web1",durable = "true"),
            exchange = @Exchange(value = "spring.exchange.logistics",ignoreDeclarationExceptions = "true"),
            key = "logistics"))
    public  void web1(String msg){
        System.out.println("web1接收到消息："+msg);
    }
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "order.to.web2",durable = "true"),
            exchange = @Exchange(value = "spring.exchange.order",ignoreDeclarationExceptions = "true"),
            key = "order"))
    public  void web2(String msg){
        System.out.println("web2接收到消息："+msg);
    }
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "order.to.logistics",durable = "true"),
            exchange = @Exchange(value = "spring.exchange.order",ignoreDeclarationExceptions = "true"),
            key = "order"))
    public  void logistics(String msg){
        System.out.println("logistics接收到消息："+msg);
    }

}
