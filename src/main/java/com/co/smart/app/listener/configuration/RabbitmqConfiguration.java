package com.co.smart.app.listener.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitmqConfiguration {

    private final MeasurementAddedQueueConfiguration measurementAddedQueue;

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
    TopicExchange dlqExchange() {
        return new TopicExchange("smart.dlq");
    }

    //endregion

    //region Measurement added queue configuration

    @Bean
    Queue measurementAddedQueue() {
        return new Queue(measurementAddedQueue.getQueue(), false);
    }

    @Bean
    Binding measurementAddedBinding(Queue queue, TopicExchange devicesExchange) {
        return BindingBuilder.bind(queue).to(devicesExchange).with(measurementAddedQueue.getRoutingKey());
    }

    //endregion
}
