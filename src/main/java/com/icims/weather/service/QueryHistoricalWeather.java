package com.icims.weather.service;

import com.icims.weather.model.WeatherRequest;
import com.icims.weather.model.WeatherResponse;

public interface QueryHistoricalWeather {
    WeatherResponse getHistoricalWeather(WeatherRequest weatherRequest);
}
