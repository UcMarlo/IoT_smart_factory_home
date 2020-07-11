package com.co.smart.app.rest;

import com.co.smart.domain.device.MetricsProviderRepository;
import com.co.smart.domain.measurement.Measurement;
import com.co.smart.domain.measurement.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class RequestController {

    @Autowired
    private MetricsProviderRepository metricsProviderRepository;
    @Autowired
    private MeasurementRepository measurementRepository;

    @GetMapping("api/Measurements")
    public List<Measurement> getMeasurements(@RequestParam String name, @RequestParam String timestamp){

        Date date =null;
        try{
        date = new SimpleDateFormat("yyyy/MM/dd").parse(timestamp);}
        catch (Exception e){
        }

        var provider = metricsProviderRepository.findByName(name);

        return  measurementRepository.findByMetricIdAndTimestampAfter(provider.get().getId(),date);
    }

    @GetMapping("api/LastMeasurement")
    public Measurement getLastMeasurement(@RequestParam String name){
        var provider = metricsProviderRepository.findByName(name);

        return  measurementRepository.getLastMeasurement(provider.get().getId());
    }
}
