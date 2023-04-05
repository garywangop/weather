package com.icims.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HourlyUnits {

    private String time;

    @JsonProperty("temperature_2m")
    private String temperatureUnit;
}
