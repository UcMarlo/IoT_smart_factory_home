package com.co.smart.app.service;

import com.co.smart.domain.device.MetricsProvider;
import com.co.smart.domain.device.MetricsProviderRepository;
import com.co.smart.domain.measurement.Measurement;
import com.co.smart.domain.measurement.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MeasurementService {
    private final MetricsProviderRepository metricsProviderRepository;
    private final MeasurementRepository measurementRepository;

    public void addNewMeasurement(String providerName, OffsetDateTime timestamp, BigDecimal value) {
        MetricsProvider metricsProvider = metricsProviderRepository.findByName(providerName)
                .orElseGet(()-> createMissingProvider(providerName));

        createNewMeasurement(metricsProvider.getId(), timestamp, value);
    }

    private void createNewMeasurement(Integer providerId, OffsetDateTime timestamp, BigDecimal value){
        measurementRepository.save(
                new Measurement(providerId, value, timestamp.toLocalDate())
        );
    }

    private MetricsProvider createMissingProvider(String providerName){
        metricsProviderRepository.save(new MetricsProvider(providerName));
        return metricsProviderRepository.findByName(providerName).get();
    }
}
