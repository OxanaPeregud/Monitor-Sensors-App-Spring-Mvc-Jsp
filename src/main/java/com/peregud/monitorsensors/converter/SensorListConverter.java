package com.peregud.monitorsensors.converter;

import com.peregud.monitorsensors.domain.Sensor;
import com.peregud.monitorsensors.dto.SensorDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SensorListConverter implements Converter<List<Sensor>, List<SensorDto>> {

    @Override
    public List<SensorDto> convert(List<Sensor> sensors) {
        return sensors.stream()
                .map(sensor -> SensorDto.builder()
                        .id(sensor.getId())
                        .name(sensor.getName())
                        .model(sensor.getModel())
                        .type(sensor.getType())
                        .rangeFrom(sensor.getRangeFrom())
                        .rangeTo(sensor.getRangeTo())
                        .unit(sensor.getUnit())
                        .location(sensor.getLocation())
                        .description(sensor.getDescription())
                        .build())
                .collect(Collectors.toList());
    }
}
