package com.peregud.monitorsensors.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensorDto {
    private Long id;
    private String name;
    private String model;
    private String type;
    private Integer rangeFrom;
    private Integer rangeTo;
    private String unit;
    private String location;
    private String description;
}
