package com.peregud.monitorsensors.service.impl;

import com.peregud.monitorsensors.domain.Sensor;
import com.peregud.monitorsensors.dto.SensorDto;
import com.peregud.monitorsensors.repository.SensorRepository;
import com.peregud.monitorsensors.service.ConvertService;
import com.peregud.monitorsensors.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.peregud.monitorsensors.AppConstants.PAGE_SIZE;
import static com.peregud.monitorsensors.AppConstants.PARAM_ID;
import static com.peregud.monitorsensors.specification.SensorSpecifications.*;

@Service
public class SensorServiceImpl implements SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private ConvertService convertService;

    @Override
    public List<SensorDto> getAll(String pageNo) {
        int gotoPageNo = Integer.parseInt(pageNo);
        List<Sensor> listSensors = new ArrayList<>();
        for (Sensor sensor : sensorRepository.findAll(gotoPage(gotoPageNo))) {
            listSensors.add(sensor);
        }
        return convertService.covertList(
                listSensors,
                Sensor.class,
                SensorDto.class);
    }

    @Override
    public Long count() {
        return sensorRepository.count();
    }

    @Override
    public void saveSensor(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    @Override
    public Sensor getById(Long id) {
        return sensorRepository.getById(id);
    }

    @Override
    public void updateSensor(@NonNull Sensor sensor, Long id) {
        Sensor sensorExisting = sensorRepository.getById(id);
        sensor.setId(sensorExisting.getId());
        sensorRepository.save(sensor);
    }

    @Override
    public void deleteSensors(String[] idList) {
        for (String id : idList) {
            sensorRepository.deleteById(Long.parseLong(id));
        }
    }

    @Override
    public List<SensorDto> findSensor(String search) {
        return convertService.covertList(
                sensorRepository.findAll(shopSearch(search)),
                Sensor.class,
                SensorDto.class);
    }

    @Override
    public List<String> displayTypeList() {
        return sensorRepository.typeList();
    }

    @Override
    public List<String> displayUnitList() {
        return sensorRepository.unitList();
    }

    private PageRequest gotoPage(int page) {
        return PageRequest.of(page, PAGE_SIZE, Sort.Direction.DESC, PARAM_ID);
    }
}
