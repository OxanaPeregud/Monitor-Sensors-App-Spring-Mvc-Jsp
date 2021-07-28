package com.peregud.monitorsensors.service;

import com.peregud.monitorsensors.domain.Sensor;
import com.peregud.monitorsensors.dto.SensorDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SensorService {

    List<SensorDto> getAll(String pageNo);

    Long count();

    void saveSensor(Sensor sensor);

    Sensor getById(Long id);

    void updateSensor(Sensor sensor, Long id);

    void deleteSensors(String[] idList);

    List<SensorDto> findSensor(String search);

    List<String> displayTypeList();

    List<String> displayUnitList();
}
