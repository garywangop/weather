package com.icims.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse {
//    @JsonProperty("latitude")
    private String latitude;

//    @JsonProperty("longitude")
    private String longitude;

    @JsonProperty("generationtime_ms")
    private String time;

//    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("timezone_abbreviation")
    private String abbreviation;

    @JsonProperty("hourly")
    private HourlyTemperature hourlyTemperature;

    @JsonProperty("hourly_units")
    private HourlyUnits hourlyUnits;

    private Boolean error;

    @JsonProperty("reason")
    private String errorMessage;
}
