package com.icims.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OpenMeteoError {
    private Boolean error;

    @JsonProperty("reason")
    private String errorMessage;
}
