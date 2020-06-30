package com.co.smart.domain.measurement;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name= "measurements")
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer metricId;

    @NotNull
    private BigDecimal value;

    @NotNull
    private LocalDate timestamp;

    public Measurement(Integer metricId, BigDecimal value, LocalDate timestamp) {
        this.metricId = metricId;
        this.value = value;
        this.timestamp = timestamp;
    }
}
