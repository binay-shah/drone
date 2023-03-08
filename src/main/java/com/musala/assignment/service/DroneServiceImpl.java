package com.musala.assignment.service;


import com.musala.assignment.entity.Drone;
import com.musala.assignment.repository.DroneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneServiceImpl implements DroneService{


    private DroneRepository droneRepository;

    public DroneServiceImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    public List<Drone> retrieveDrones() {
        return (List<Drone>) droneRepository.findAll();
    }

    @Override
    public Drone registerDrone(Drone drone) {
        return droneRepository.save(drone);
    }

    @Override
    public double checkBatteryLevel(Long id) {
        return 0;
    }

    @Override
    public List<Drone> retrieveDronesForLoading() {
        return  droneRepository.findDronesForLoading();
    }

    @Override
    public int checkBatteryLevelById(Long droneId) {
        return droneRepository.findBatteryLevelById(droneId);
    }
}
