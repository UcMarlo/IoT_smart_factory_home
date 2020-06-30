package com.co.smart.domain.device;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MetricsProviderRepository extends JpaRepository<MetricsProvider, Long> {

    Optional<MetricsProvider> findByName(String name);

}
