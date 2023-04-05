package com.icims.weather.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int a;
//    @Transient
//    private String[] weatherRequest;
//
//    @Transient
//    private WeatherResponse weatherResponse;
}
