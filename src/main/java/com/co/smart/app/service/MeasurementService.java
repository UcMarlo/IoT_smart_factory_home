package com.co.smart.app.service;

import com.co.smart.domain.device.MetricsProviderRepository;
import com.co.smart.domain.measurement.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeasurementService {
    private final MetricsProviderRepository metricsProviderRepository;
    private final MeasurementRepository measurementRepository;

}
