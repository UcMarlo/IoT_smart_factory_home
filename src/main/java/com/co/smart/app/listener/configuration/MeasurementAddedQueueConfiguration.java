package com.co.smart.app.listener.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "message-broker.queues.measurement-added")
public class MeasurementAddedQueueConfiguration {
    String routingKey;
    String queue;
    String exchangeName;
}
