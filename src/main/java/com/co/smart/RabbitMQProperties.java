package com.co.smart;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
public class RabbitMQProperties {

    private String queueName;
    private String exchangeName;
    private String routingKey;
    private String queueName2;
    private String exchangeName2;
    private String routingKey2;

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getQueueName2() {
        return queueName2;
    }

    public void setQueueName2(String queueName2) {
        this.queueName2 = queueName2;
    }

    public String getExchangeName2() {
        return exchangeName2;
    }

    public void setExchangeName2(String exchangeName2) {
        this.exchangeName2 = exchangeName2;
    }

    public String getRoutingKey2() {
        return routingKey2;
    }

    public void setRoutingKey2(String routingKey2) {
        this.routingKey2 = routingKey2;
    }
}
