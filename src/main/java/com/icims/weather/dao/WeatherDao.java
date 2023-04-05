package com.icims.weather.dao;

import com.icims.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDao extends JpaRepository<Weather, Integer> {
}
