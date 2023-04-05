package com.icims.weather.model;

import com.icims.weather.model.Entity.Temperature;
import com.icims.weather.model.Entity.Weather;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {

    private Weather weather;

    private List<Temperature> temperatures;

}
