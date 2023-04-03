package com.icims.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HourlyUnits {

    private String time;

    @JsonProperty("temperature_2m")
    private String temperatureUnit;
}
