package com.icims.weather.client;

import com.icims.weather.exception.OpenMeteoClientException;
import com.icims.weather.model.OpenMeteoError;
import com.icims.weather.model.WeatherRequest;
import com.icims.weather.model.OpenMeteoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Component
public class OpenMeteoClient {
    private static final String HISTORICAL_WEATHER_URL = "https://archive-api.open-meteo.com/v1/archive?hourly=temperature_2m";

    public OpenMeteoResponse getHistoricalWeather(WeatherRequest weatherRequest) {
        String url = buildUrl(weatherRequest);
        WebClient.Builder builder = WebClient.builder();

        OpenMeteoResponse openMeteoResponse = builder
                .codecs(configurer -> configurer.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder()))
                .build()
                .get()
                .uri(url)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> {
                    // handle 4xx client errors
                    return clientResponse.bodyToMono(OpenMeteoError.class)
                            .flatMap(errorBody -> Mono.error(new OpenMeteoClientException("Client error: " + errorBody.getErrorMessage())));
                })
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> {
                    // handle 5xx server errors
                    return Mono.error(new OpenMeteoClientException("Server error: " + clientResponse.statusCode()));
                })
                .bodyToMono(OpenMeteoResponse.class)
                .block();

        return openMeteoResponse;
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
