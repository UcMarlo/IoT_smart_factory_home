package com.co.smart.domain.measurement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

    @Query(value = "select * from measurements m  where m.metric_id = :device order by timestamp desc limit 1", nativeQuery = true)
    Measurement getLastMeasurement(@Param("device") int id);

    @Query (value = "select * from measurements m where m.metric_id = :device and m.timestamp >= :date", nativeQuery = true)
    List<Measurement> findByMetricIdAndTimestampAfter(@Param("device") int metricId,@Param("date") Date timestamp);
}
