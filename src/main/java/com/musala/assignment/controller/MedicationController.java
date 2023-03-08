package com.musala.assignment.controller;


import com.musala.assignment.dto.MedicationDto;
import com.musala.assignment.exception.BatteryLowException;
import com.musala.assignment.exception.DroneOverLoadedException;
import com.musala.assignment.service.MedicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class MedicationController {

    private MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping("/drones/{droneId}/medications")
    public List<MedicationDto> getMedicationsByDroneId(@PathVariable(value = "droneId") Long droneId){
        return medicationService.getMedicationItemsByDroneId(droneId);
    }

    @PostMapping("/drones/{droneId}/medication")
    public ResponseEntity<MedicationDto> loadMedicationItem(@PathVariable(value = "droneId") long droneId,
                                                            @RequestBody MedicationDto medicationDto) throws DroneOverLoadedException, BatteryLowException {
        return new ResponseEntity<>(medicationService.loadMedication(droneId, medicationDto), HttpStatus.CREATED);
    }
}
