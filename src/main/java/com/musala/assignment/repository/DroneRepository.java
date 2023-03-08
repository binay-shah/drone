package com.musala.assignment.repository;


import com.musala.assignment.entity.Drone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneRepository extends CrudRepository<Drone, Long> {

    @Query("select d.id, d.serialNumber, d.model, d.weight, d.batteryCapacity, d.state from Drone d where d.state= 'LOADING'")
    List<Drone> findDronesForLoading();

    @Query("select d.batteryCapacity from Drone d where d.batteryCapacity= :droneId")
    int findBatteryLevelById(Long droneId);

}
