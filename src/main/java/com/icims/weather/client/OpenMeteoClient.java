package com.icims.weather.client;

import com.icims.weather.model.WeatherRequest;
import com.icims.weather.model.WeatherResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class OpenMeteoClient {
    private static final String HISTORICAL_WEATHER_URL = "https://archive-api.open-meteo.com/v1/archive?hourly=temperature_2m";

    public WeatherResponse getHistoricalWeather(WeatherRequest weatherRequest) {
        String url = buildUrl(weatherRequest);
        WebClient.Builder builder = WebClient.builder();

        try {
            WeatherResponse weatherResponse = builder.build()
                    .get()
                    .uri(url)
                    .retrieve()
                    .bodyToFlux(WeatherResponse.class)
                    .blockLast();

            return weatherResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String buildUrl(WeatherRequest weatherRequest) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(HISTORICAL_WEATHER_URL)
                .queryParam("latitude", weatherRequest.getLatitude())
                .queryParam("longitude", weatherRequest.getLongitude())
                .queryParam("start_date", weatherRequest.getStartDate())
                .queryParam("end_date", weatherRequest.getEndDate());

        return uriComponentsBuilder.toUriString();
    }
}
