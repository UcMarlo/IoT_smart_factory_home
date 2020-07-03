package com.co.smart;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Measurement implements Serializable {

    private String metricName;
    private BigDecimal value;
    private LocalDateTime timestamp;

    public Measurement(String metricName, BigDecimal value, LocalDateTime timestamp) {
        this.metricName = metricName;
        this.value = value;
        this.timestamp = timestamp;
    }

    public Measurement() {
    }


    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricId) {
        this.metricName = metricId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
