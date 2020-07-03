package com.co.smart;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    RabbitMQProperties rabbitMQProperties;

    @GetMapping("/start")
    public void sendMessage() {
        try {
            while (true) {
                Thread.sleep(10000);
                double randomNum = ThreadLocalRandom.current().nextInt(0, 10000);
                var measure = new Measurement("temp",BigDecimal.valueOf(randomNum/1000),LocalDateTime.now());
                System.out.println("Send msg = " + measure);

                rabbitTemplate.convertAndSend(rabbitMQProperties.getExchangeName(), rabbitMQProperties.getRoutingKey(), measure);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
