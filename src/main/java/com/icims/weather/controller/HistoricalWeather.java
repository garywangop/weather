package com.icims.weather.controller;

import com.icims.weather.model.WeatherRequest;
import com.icims.weather.model.OpenMeteoResponse;
import com.icims.weather.service.QueryHistoricalWeather;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "weather")
public class HistoricalWeather {
    private QueryHistoricalWeather queryHistoricalWeather;

    public HistoricalWeather(QueryHistoricalWeather queryHistoricalWeather) {
        this.queryHistoricalWeather = queryHistoricalWeather;
    }

    @GetMapping("historical")
    public ResponseEntity<OpenMeteoResponse> getWeatherData(@RequestBody @Valid WeatherRequest weatherRequest) {

        OpenMeteoResponse openMeteoResponse = queryHistoricalWeather.getHistoricalWeather(weatherRequest);

        return ResponseEntity.ok(openMeteoResponse);
    }
}
