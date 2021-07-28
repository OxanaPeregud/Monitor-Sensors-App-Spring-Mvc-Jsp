package com.peregud.monitorsensors.converter.builder;

import com.peregud.monitorsensors.domain.Sensor;

import java.util.Optional;

public class SensorBuilder {

    public static Sensor insertSensor(Long id, String name, String model, String type, Integer rangeFrom,
                                      Integer rangeTo, String unit, String location, String description) {
        Sensor.SensorBuilder builder = Sensor.builder();
        Optional.ofNullable(id)
                .ifPresent(builder::id);
        return Sensor.builder()
                .name(name)
                .model(model)
                .type(type)
                .rangeFrom(rangeFrom)
                .rangeTo(rangeTo)
                .unit(unit)
                .location(location)
                .description(description)
                .build();
    }
}
