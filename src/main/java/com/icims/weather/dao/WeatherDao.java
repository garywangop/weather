package com.icims.weather.dao;

import com.icims.weather.model.Entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WeatherDao extends JpaRepository<Weather, Long> {
    Optional<Weather> findByLatitudeAndLongitudeAndStartDateAndEndDate(String latitude, String longitude, String startDate, String endDate);
}
