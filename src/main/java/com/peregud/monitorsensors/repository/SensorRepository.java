package com.peregud.monitorsensors.repository;

import com.peregud.monitorsensors.domain.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long>, JpaSpecificationExecutor<Sensor> {

    @Query("select t.name as name from Type t")
    List<String> typeList();

    @Query("select u.name as name from Unit u")
    List<String> unitList();
}
