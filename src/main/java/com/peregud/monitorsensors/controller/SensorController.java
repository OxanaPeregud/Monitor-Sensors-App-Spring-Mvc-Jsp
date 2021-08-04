package com.peregud.monitorsensors.controller;

import com.peregud.monitorsensors.converter.builder.SensorBuilder;
import com.peregud.monitorsensors.domain.Sensor;
import com.peregud.monitorsensors.dto.SensorDto;
import com.peregud.monitorsensors.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.peregud.monitorsensors.AppConstants.*;

@Controller
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping(PAGE_SENSORS_LIST)
    public String displaySensors(Model model,
                                 @RequestParam(value = PARAM_PAGE_NUMBER, required = false,
                                         defaultValue = PAGE_NUMBER_DEFAULT)
                                         String pageNo) {
        List<SensorDto> listSensors = sensorService.getAll(pageNo);
        int lastPageNo;
        long totalUsersCount = sensorService.count();
        if (totalUsersCount % PAGE_SIZE != 0) {
            lastPageNo = (int) (totalUsersCount / PAGE_SIZE) + 1;
        } else {
            lastPageNo = (int) (totalUsersCount / PAGE_SIZE);
        }
        model.addAttribute(ATTR_LAST_PAGE, lastPageNo);
        model.addAttribute(ATTR_LIST_SENSORS, listSensors);
        return VIEW_SENSORS_LIST;
    }

    @GetMapping(PAGE_SENSORS_ADD)
    public String addSensor(Model model) {
        List<String> listTypes = sensorService.displayTypeList();
        model.addAttribute(ATTR_LIST_TYPES, listTypes);
        List<String> listUnits = sensorService.displayUnitList();
        model.addAttribute(ATTR_LIST_UNITS, listUnits);
        return VIEW_SENSOR_FORM;
    }

    @PostMapping(PAGE_SENSORS_INSERT)
    public ModelAndView insertSensor(@RequestParam(required = false, value = PARAM_ID) Long id,
                                     @RequestParam(PARAM_NAME) String name,
                                     @RequestParam(PARAM_MODEL) String model,
                                     @RequestParam(PARAM_TYPE) String type,
                                     @RequestParam(required = false, value = PARAM_RANGE_FROM) Integer rangeFrom,
                                     @RequestParam(required = false, value = PARAM_RANGE_TO) Integer rangeTo,
                                     @RequestParam(PARAM_UNIT) String unit,
                                     @RequestParam(required = false, value = PARAM_LOCATION) String location,
                                     @RequestParam(required = false, value = PARAM_DESCRIPTION) String description,
                                     ModelMap modelMap) {
        Sensor sensor = SensorBuilder.insertSensor(
                id, name, model, type, rangeFrom, rangeTo, unit, location, description);
        sensorService.saveSensor(sensor);
        return new ModelAndView(REDIRECT_SENSORS_LIST, modelMap);
    }

    @GetMapping(PAGE_SENSORS_EDIT)
    public String editSensor(@RequestParam(PARAM_ID) Long id, Model model) {
        Sensor sensor = sensorService.getById(id);
        model.addAttribute(ATTR_SENSOR, sensor);
        List<String> listTypes = sensorService.displayTypeList();
        model.addAttribute(ATTR_LIST_TYPES, listTypes);
        List<String> listUnits = sensorService.displayUnitList();
        model.addAttribute(ATTR_LIST_UNITS, listUnits);
        return VIEW_SENSOR_FORM;
    }

    @PostMapping(PAGE_SENSORS_UPDATE)
    public ModelAndView updateSensor(@RequestParam(PARAM_ID) Long id,
                                     @RequestParam(PARAM_NAME) String name,
                                     @RequestParam(PARAM_MODEL) String model,
                                     @RequestParam(PARAM_TYPE) String type,
                                     @RequestParam(required = false, value = PARAM_RANGE_FROM) Integer rangeFrom,
                                     @RequestParam(required = false, value = PARAM_RANGE_TO) Integer rangeTo,
                                     @RequestParam(PARAM_UNIT) String unit,
                                     @RequestParam(required = false, value = PARAM_LOCATION) String location,
                                     @RequestParam(required = false, value = PARAM_DESCRIPTION) String description,
                                     ModelMap modelMap) {
        Sensor sensor = SensorBuilder.insertSensor(
                id, name, model, type, rangeFrom, rangeTo, unit, location, description);
        sensorService.updateSensor(sensor, id);
        return new ModelAndView(REDIRECT_SENSORS_LIST, modelMap);
    }

    @PostMapping(PAGE_SENSORS_DELETE)
    public ModelAndView deleteSensors(@RequestParam(PARAM_DELETE_SENSOR) String[] idList, ModelMap model) {
        sensorService.deleteSensors(idList);
        return new ModelAndView(REDIRECT_SENSORS_LIST, model);
    }

    @PostMapping(PAGE_SENSORS_SEARCH_RESULT)
    public String searchSensor(@RequestParam(PARAM_SEARCH) String search, Model model) {
        List<SensorDto> listSensors = sensorService.findSensor(search);
        model.addAttribute(ATTR_LIST_SENSORS, listSensors);
        return VIEW_SENSOR_SEARCH_RESULT;
    }
}
