package com.co.smart.app.listener.dto;

import lombok.Value;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Value
public class MeasurementAddedEvent {
    String deviceName;
    BigDecimal value;
    OffsetDateTime timestamp;
}
