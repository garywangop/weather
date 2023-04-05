package com.icims.weather.dao;

import com.icims.weather.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemperatureDao extends JpaRepository<Temperature, Long> {
    List<Temperature> findAllByWeatherId(long id);
}
