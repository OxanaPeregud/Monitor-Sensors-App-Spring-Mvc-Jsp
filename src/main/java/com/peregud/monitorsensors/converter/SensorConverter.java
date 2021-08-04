package com.peregud.monitorsensors.converter;

import com.peregud.monitorsensors.domain.Sensor;
import com.peregud.monitorsensors.dto.SensorDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SensorConverter implements Converter<Sensor, SensorDto> {

    @Override
    public SensorDto convert(Sensor sensor) {
        SensorDto.SensorDtoBuilder builder = SensorDto.builder();
        Optional.ofNullable(sensor.getId())
                .ifPresent(builder::id);
        return builder
                .name(sensor.getName())
                .model(sensor.getModel())
                .type(sensor.getType())
                .rangeFrom(sensor.getRangeFrom())
                .rangeTo(sensor.getRangeTo())
                .unit(sensor.getUnit())
                .location(sensor.getLocation())
                .description(sensor.getDescription())
                .build();
    }
}
