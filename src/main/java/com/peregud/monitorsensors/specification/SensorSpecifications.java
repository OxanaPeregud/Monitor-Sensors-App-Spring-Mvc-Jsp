package com.peregud.monitorsensors.specification;

import com.peregud.monitorsensors.domain.Sensor;
import com.peregud.monitorsensors.domain.Sensor_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class SensorSpecifications {

    public static Specification<Sensor> shopSearch(String search) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            predicateList.add(criteriaBuilder.like(criteriaBuilder.lower(
                    root.get(Sensor_.NAME)), "%" + search.toLowerCase() + "%"));
            predicateList.add(criteriaBuilder.like(criteriaBuilder.lower(
                    root.get(Sensor_.MODEL)), "%" + search.toLowerCase() + "%"));
            predicateList.add(criteriaBuilder.like(criteriaBuilder.lower(
                    root.get(Sensor_.TYPE)), "%" + search.toLowerCase() + "%"));
            predicateList.add(criteriaBuilder.like(criteriaBuilder.lower(
                    root.get(Sensor_.DESCRIPTION)), "%" + search.toLowerCase() + "%"));
            return criteriaBuilder.or(predicateList.toArray(new Predicate[0]));
        };
    }
}
