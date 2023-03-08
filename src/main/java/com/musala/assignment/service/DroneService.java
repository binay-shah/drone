package com.musala.assignment.service;


import com.musala.assignment.entity.Drone;

import java.util.List;


public interface DroneService {

     List<Drone> retrieveDrones();
     Drone registerDrone(Drone drone);
     double checkBatteryLevel(Long id);
     List<Drone> retrieveDronesForLoading();
     int checkBatteryLevelById(Long droneId);
}
