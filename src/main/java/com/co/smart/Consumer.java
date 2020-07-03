package com.co.smart;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = "${rabbitmq.queueName2}")
    public void listen(byte[] message) {
        try {
            String msg = new String(message);
            System.out.println("Received a new notification... consumer");
            System.out.println(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
