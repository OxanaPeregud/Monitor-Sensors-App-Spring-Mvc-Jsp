package com.peregud.monitorsensors.service.impl;

import com.peregud.monitorsensors.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvertServiceImpl implements ConvertService {

    @Autowired
    private ConversionService conversionService;

    @Override
    public <T, E> E convertEntity(T source, Class<E> targetClass) {
        return conversionService.convert(source, targetClass);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T, E> List<E> covertList(List<T> source, Class<T> sourceClass, Class<E> targetClass) {
        TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(sourceClass));
        TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(targetClass));
        return (List<E>) conversionService.convert(source, sourceType, targetType);
    }
}
