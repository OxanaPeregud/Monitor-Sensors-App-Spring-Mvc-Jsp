package com.peregud.monitorsensors.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConvertService {

    <T, E> List<E> covertList(List<T> source, Class<T> sourceClass, Class<E> targetClass);
}
