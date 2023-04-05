package com.icims.weather.service;

import com.icims.weather.model.WeatherRequest;
import com.icims.weather.model.OpenMeteoResponse;

public interface QueryHistoricalWeather {
    OpenMeteoResponse getHistoricalWeather(WeatherRequest weatherRequest);
}
