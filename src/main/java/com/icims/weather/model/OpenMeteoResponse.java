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
public class OpenMeteoResponse {

    private String latitude;

    private String longitude;

    @JsonProperty("generationtime_ms")
    private String time;

    private String timezone;

    @JsonProperty("timezone_abbreviation")
    private String abbreviation;

    @JsonProperty("hourly")
    private HourlyTemperature hourlyTemperature;

    @JsonProperty("hourly_units")
    private HourlyUnits hourlyUnits;

}
