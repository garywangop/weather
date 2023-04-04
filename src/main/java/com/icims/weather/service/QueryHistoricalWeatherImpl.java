package com.icims.weather.service;

import com.icims.weather.client.OpenMeteoClient;
import com.icims.weather.model.WeatherRequest;
import com.icims.weather.model.WeatherResponse;
import org.springframework.stereotype.Service;

@Service
public class QueryHistoricalWeatherImpl implements QueryHistoricalWeather{

    private OpenMeteoClient openMeteoClient;

    public QueryHistoricalWeatherImpl(OpenMeteoClient openMeteoClient) {
        this.openMeteoClient = openMeteoClient;
    }

    @Override
    public WeatherResponse getHistoricalWeather(WeatherRequest weatherRequest) {
        WeatherResponse weatherResponse = openMeteoClient.getHistoricalWeather(weatherRequest);
        return weatherResponse;
    }
}
