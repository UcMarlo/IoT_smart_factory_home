package com.co.smart.domain.measurement;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name= "measurements")
@Data
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
}
