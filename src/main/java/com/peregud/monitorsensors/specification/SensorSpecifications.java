package com.peregud.monitorsensors.specification;

import com.peregud.monitorsensors.domain.Sensor;
import com.peregud.monitorsensors.domain.Sensor_;
import org.springframework.data.jpa.domain.Specification;

public class SensorSpecifications {

    public static Specification<Sensor> nameSearch(String search) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(
                        root.get(Sensor_.NAME)), "%" + search.toLowerCase() + "%");
    }

    public static Specification<Sensor> modelSearch(String search) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(
                        root.get(Sensor_.MODEL)), "%" + search.toLowerCase() + "%");
    }

    public static Specification<Sensor> typeSearch(String search) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(
                        root.get(Sensor_.TYPE)), "%" + search.toLowerCase() + "%");
    }

    public static Specification<Sensor> descriptionSearch(String search) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(
                        root.get(Sensor_.DESCRIPTION)), "%" + search.toLowerCase() + "%");
    }
}
