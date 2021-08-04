package com.peregud.monitorsensors.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.servlet.MockMvc;

import static com.peregud.monitorsensors.AppConstants.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SensorController.class)
class SensorControllerTest extends MockInit {

    @Autowired
    protected MockMvc mockMvc;

    @Test
    void addSensor() throws Exception {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(ATTR_ADMIN);
        this.mockMvc.perform(get(PAGE_SENSORS_ADD)
                .with(csrf())
                .with(user(ATTR_ADMIN).authorities(grantedAuthority)))
                .andExpect(status().isOk())
                .andExpect(model().size(2))
                .andExpect(model().attributeExists(ATTR_LIST_TYPES, ATTR_LIST_UNITS))
                .andExpect(view().name(VIEW_SENSOR_FORM))
                .andReturn();
    }

    @Test
    void insertSensor() throws Exception {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(ATTR_ADMIN);
        this.mockMvc.perform(post(PAGE_SENSORS_INSERT)
                .param(PARAM_NAME, "1")
                .param(PARAM_MODEL, "1")
                .param(PARAM_TYPE, "1")
                .param(PARAM_UNIT, "1")
                .with(csrf())
                .with(user(ATTR_ADMIN).authorities(grantedAuthority)))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl(PAGE_SENSORS_LIST))
                .andReturn();
    }

    @Test
    void editSensor() throws Exception {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(ATTR_ADMIN);
        this.mockMvc.perform(get(PAGE_SENSORS_EDIT)
                .param(PARAM_ID, "1")
                .with(csrf())
                .with(user(ATTR_ADMIN).authorities(grantedAuthority)))
                .andExpect(status().isOk())
                .andExpect(model().size(3))
                .andExpect(model().attributeExists(ATTR_LIST_TYPES, ATTR_LIST_UNITS))
                .andExpect(view().name(VIEW_SENSOR_FORM))
                .andReturn();
    }

    @Test
    void updateSensor() throws Exception {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(ATTR_ADMIN);
        this.mockMvc.perform(post(PAGE_SENSORS_UPDATE)
                .param(PARAM_ID, "1")
                .param(PARAM_NAME, "1")
                .param(PARAM_MODEL, "1")
                .param(PARAM_TYPE, "1")
                .param(PARAM_UNIT, "1")
                .with(csrf())
                .with(user(ATTR_ADMIN).authorities(grantedAuthority)))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl(PAGE_SENSORS_LIST))
                .andReturn();
    }

    @Test
    void deleteSensors() throws Exception {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(ATTR_ADMIN);
        this.mockMvc.perform(post(PAGE_SENSORS_DELETE)
                .param(PARAM_DELETE_SENSOR, "1")
                .with(csrf())
                .with(user(ATTR_ADMIN).authorities(grantedAuthority)))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl(PAGE_SENSORS_LIST))
                .andReturn();
    }

    @Test
    void searchSensor() throws Exception {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(ATTR_ADMIN);
        this.mockMvc.perform(post(PAGE_SENSORS_SEARCH_RESULT)
                .param(PARAM_SEARCH, "1")
                .with(csrf())
                .with(user(ATTR_ADMIN).authorities(grantedAuthority)))
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(model().attributeExists(ATTR_LIST_SENSORS))
                .andExpect(view().name(VIEW_SENSOR_SEARCH_RESULT))
                .andReturn();
    }
}
