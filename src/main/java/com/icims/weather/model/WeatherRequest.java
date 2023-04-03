package com.icims.weather.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class WeatherRequest {
    @NotNull(message = "Value of type 'Float' required for key 'latitude'.")
    @Pattern(regexp = "^[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?$", message = "Latitude must be a valid float value")
    @DecimalMin("-90.0")
    @DecimalMax("90.0")
    private String latitude;

    @NotNull(message = "Value of type 'Float' required for key 'longitude'.")
    @Pattern(regexp = "^[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?$", message = "Longitude must be a valid float value")
    @DecimalMin("-180.0")
    @DecimalMax("180.0")
    private String longitude;

    @NotNull
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Invalid date format. Make sure to use 'YYYY-MM-DD'")
    private String startDate;

    @NotNull
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Invalid date format. Make sure to use 'YYYY-MM-DD'")
    private String endDate;
}
