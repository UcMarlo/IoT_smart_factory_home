package com.co.smart.app.listener;

import com.co.smart.app.listener.dto.MeasurementAddedEvent;
import com.co.smart.app.service.MeasurementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MeasurementAddedListener {

    private final MeasurementService measurementService;


    @RabbitListener(queues = {"${queues.measurementAdded}"})
    public void measurementAddedEventHandler(MeasurementAddedEvent event){
        log.info("Received event: {}", event);

        measurementService.addNewMeasurement(event.getMetricName(), event.getTimestamp(), event.getValue());
    }
}
