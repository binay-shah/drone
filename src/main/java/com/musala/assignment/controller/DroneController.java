package com.musala.assignment.controller;

import com.musala.assignment.entity.Drone;
import com.musala.assignment.service.DroneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/drones", produces = { MediaType.APPLICATION_JSON_VALUE  })
public class DroneController {

    private DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @GetMapping
    public ResponseEntity<List<Drone>> getAllDrones(){
        List<Drone> list = droneService.retrieveDrones();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/loading")
    public ResponseEntity<List<Drone>> getAllDronesForLoading(){
        List<Drone> list = droneService.retrieveDronesForLoading();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{droneId}/battery_level")
    public ResponseEntity<Integer> checkBatteryLevelById(@PathVariable(value = "droneId") Long droneId){
       int batteryLevel = droneService.checkBatteryLevelById(droneId);
        return new ResponseEntity<Integer>(batteryLevel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Drone> registerDrone(@RequestBody Drone drone){
        Drone newDrone = droneService.registerDrone(drone);
        return new ResponseEntity<>(newDrone, HttpStatus.CREATED);
    }



}
