package com.peregud.monitorsensors.config;

import com.peregud.monitorsensors.converter.SensorConverter;
import com.peregud.monitorsensors.converter.SensorListConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConverterConfig implements WebMvcConfigurer {

    @Bean
    public ConversionService conversionService() {
        DefaultConversionService service = new DefaultConversionService();
        service.addConverter(new SensorListConverter());
        service.addConverter(new SensorConverter());
        return service;
    }
}
