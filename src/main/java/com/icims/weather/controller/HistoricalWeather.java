package com.icims.weather.controller;

import com.icims.weather.client.OpenMeteoClient;
import com.icims.weather.model.WeatherRequest;
import com.icims.weather.model.WeatherResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController()
@RequestMapping(path = "weather")
public class HistoricalWeather {
    private OpenMeteoClient openMeteoClient;

    public HistoricalWeather(OpenMeteoClient openMeteoClient) {
        this.openMeteoClient = openMeteoClient;
    }

    @GetMapping("historical")
    public ResponseEntity<WeatherResponse> getWeatherData(@RequestBody @Valid WeatherRequest weatherRequest) {

        WeatherResponse weatherResponse = openMeteoClient.getHistoricalWeather(weatherRequest);

        return ResponseEntity.ok(weatherResponse);
    }
}
