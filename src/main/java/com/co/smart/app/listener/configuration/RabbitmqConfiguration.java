package com.co.smart.app.listener.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class RabbitmqConfiguration {

    private static final String SMART_DLQ = "smart.dlq";

    private final MeasurementAddedQueueConfiguration measurementAddedQueueConfiguration;

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        objectMapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        return new Jackson2JsonMessageConverter(objectMapper);
    }

    //region External and internal exchanges

    @Bean
    TopicExchange devicesExchange() {
        return new TopicExchange("devices");
    }

    @Bean
    FanoutExchange dlqExchange() {
        return new FanoutExchange(SMART_DLQ);
    }

    //endregion

    //region queue config

    @Bean
    Queue dlqQueue(){
        return new Queue(SMART_DLQ);
    }

    @Bean
    Binding dlqBinding(Queue dlqQueue, TopicExchange dlqExchange) {
        return BindingBuilder.bind(dlqQueue).to(dlqExchange).with(SMART_DLQ);
    }
    //endregion

    //region Measurement added queue configuration

    @Bean
    Queue measurementAddedQueue() {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-dead-letter-exchange", SMART_DLQ);
        args.put("x-dead-letter-routing-key", SMART_DLQ);
        return new Queue(measurementAddedQueueConfiguration.getQueue(), true, false,false, args);
    }

    @Bean
    Binding measurementAddedBinding(Queue measurementAddedQueue, TopicExchange devicesExchange) {
        return BindingBuilder.bind(measurementAddedQueue).to(devicesExchange).with(measurementAddedQueueConfiguration.getRoutingKey());
    }

    //endregion
}
