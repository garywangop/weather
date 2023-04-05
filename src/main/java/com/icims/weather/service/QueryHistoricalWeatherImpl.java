package com.icims.weather.service;

import com.icims.weather.client.OpenMeteoClient;
import com.icims.weather.dao.WeatherDao;
import com.icims.weather.model.WeatherRequest;
import com.icims.weather.model.OpenMeteoResponse;
import org.springframework.stereotype.Service;

@Service
public class QueryHistoricalWeatherImpl implements QueryHistoricalWeather{

    private OpenMeteoClient openMeteoClient;
    private WeatherDao weatherDao;

    public QueryHistoricalWeatherImpl(OpenMeteoClient openMeteoClient, WeatherDao weatherDao) {
        this.openMeteoClient = openMeteoClient;
        this.weatherDao = weatherDao;
    }

    @Override
    public OpenMeteoResponse getHistoricalWeather(WeatherRequest weatherRequest) {
        OpenMeteoResponse openMeteoResponse = openMeteoClient.getHistoricalWeather(weatherRequest);
        return openMeteoResponse;
    }

}
