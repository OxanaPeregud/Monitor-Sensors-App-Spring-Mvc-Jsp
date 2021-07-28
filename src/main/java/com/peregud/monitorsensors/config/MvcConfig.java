package com.peregud.monitorsensors.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.peregud.monitorsensors.AppConstants.*;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(@NonNull ViewControllerRegistry registry) {
        registry.addViewController(PAGE_LOGIN).setViewName(VIEW_LOGIN);
        registry.addViewController(PAGE_SENSORS_SEARCH).setViewName(VIEW_SENSOR_SEARCH);
        registry.addViewController(PAGE_SIGN_UP).setViewName(VIEW_SIGN_UP);
        registry.addViewController(PAGE_SUCCESS).setViewName(VIEW_SUCCESS);
        registry.addViewController(PAGE_ACCESS_DENIED).setViewName(VIEW_ACCESS_DENIED);
        registry.addViewController(PAGE_LOGIN_FAILED).setViewName(VIEW_LOGIN_FAILED);
    }
}
