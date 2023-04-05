package com.icims.weather.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String latitude;

    private String longitude;

    private String startDate;

    private String endDate;

    private String time;

    private String timezone;

    private String abbreviation;

    @Column(name = "temperature_unit")
    private String temperatureUnit;

    @Column(name = "time_format")
    private String timeFormat;

}
