package com.sda.weather.info.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherInfoRepository extends JpaRepository<WeatherInfo, Long> {
}
