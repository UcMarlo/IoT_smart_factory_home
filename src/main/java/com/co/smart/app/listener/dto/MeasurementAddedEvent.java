package com.co.smart.app.listener.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class MeasurementAddedEvent {
    String metricName;
    BigDecimal value;
    OffsetDateTime timestamp;
}
