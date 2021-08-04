package com.peregud.monitorsensors.controller;

import com.peregud.monitorsensors.repository.SensorRepository;
import com.peregud.monitorsensors.repository.UserRepository;
import com.peregud.monitorsensors.security.CustomAuthSuccessHandler;
import com.peregud.monitorsensors.security.DBUserDetailsService;
import com.peregud.monitorsensors.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManagerFactory;

@WebMvcTest
public class MockInit {

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    protected SensorService sensorService;

    @MockBean
    protected DBUserDetailsService dbUserDetailsService;

    @MockBean
    protected CustomAuthSuccessHandler customAuthSuccessHandler;

    @MockBean
    protected EntityManagerFactory entityManagerFactory;

    @MockBean
    protected SensorRepository sensorRepository;

    @MockBean
    protected UserRepository userRepository;
}
