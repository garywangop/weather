package com.icims.weather.service;

import com.icims.weather.client.OpenMeteoClient;
import com.icims.weather.dao.TemperatureDao;
import com.icims.weather.dao.WeatherDao;
import com.icims.weather.model.*;
import com.icims.weather.model.Entity.Temperature;
import com.icims.weather.model.Entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QueryHistoricalWeatherImpl implements QueryHistoricalWeather{

    @Autowired
    private OpenMeteoClient openMeteoClient;

    @Autowired
    private WeatherDao weatherDao;

    @Autowired
    private TemperatureDao temperatureDao;

    @Override
    public WeatherResponse getHistoricalWeather(WeatherRequest weatherRequest) {
        Optional<Weather> weather = weatherDao.findByLatitudeAndLongitude(weatherRequest.getLatitude(), weatherRequest.getLongitude());

        if (weather.isPresent()) {
            return buildWeatherResponse(weather.get());
        }

        OpenMeteoResponse openMeteoResponse = openMeteoClient.getHistoricalWeather(weatherRequest);

        return buildWeatherResponse(persistWeather(weatherRequest, openMeteoResponse));
    }

    private Weather persistWeather(WeatherRequest weatherRequest, OpenMeteoResponse openMeteoResponse) {
        Weather weather = Weather.builder()
                .latitude(weatherRequest.getLatitude())
                .longitude(weatherRequest.getLongitude())
                .startDate(weatherRequest.getStartDate())
                .endDate(weatherRequest.getEndDate())
                .time(openMeteoResponse.getTime())
                .timezone(openMeteoResponse.getTimezone())
                .abbreviation(openMeteoResponse.getAbbreviation())
                .temperatureUnit(openMeteoResponse.getHourlyUnits().getTemperatureUnit())
                .timeFormat(openMeteoResponse.getHourlyUnits().getTime())
                .build();

        Weather savedWeather = weatherDao.save(weather);

        persistTemperature(savedWeather, openMeteoResponse);

        return savedWeather;
    }

    private void persistTemperature(Weather weather, OpenMeteoResponse openMeteoResponse) {
        List<Temperature> temperatureList = new ArrayList<>();
        int size = openMeteoResponse.getHourlyTemperature().getTime().length;
        for (int i = 0; i < size; i++) {
            Temperature temperature = Temperature.builder()
                    .time(openMeteoResponse.getHourlyTemperature().getTime()[i])
                    .temperature(openMeteoResponse.getHourlyTemperature().getTemperature()[i])
                    .weather(weather)
                    .build();
            temperatureList.add(temperature);
        }

        temperatureDao.saveAll(temperatureList);
    }

    private WeatherResponse buildWeatherResponse(Weather weather) {
        List<Temperature> temperatureList = temperatureDao.findAllByWeatherId(weather.getId());
        return WeatherResponse.builder()
                .weather(weather)
                .temperatures(temperatureList)
                .build();
    }
}
