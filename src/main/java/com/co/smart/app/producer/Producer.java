package com.co.smart.app.producer;

import com.co.smart.app.listener.configuration.RabbitProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RabbitProperties properties;


    @GetMapping("/sendMessage")
    public void sendMessage(@RequestParam String msg) {
        System.out.println("Send msg = " + msg);

        rabbitTemplate.convertAndSend(properties.getExchangeName(),properties.getRoutingKey() , msg);
    }
}
