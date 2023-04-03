package com.icims.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HourlyTemperature {

    private String[] time;

    @JsonProperty("temperature_2m")
    private String[] temperature;
}
