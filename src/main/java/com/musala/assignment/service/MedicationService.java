package com.musala.assignment.service;




import com.musala.assignment.dto.MedicationDto;
import com.musala.assignment.exception.BatteryLowException;
import com.musala.assignment.exception.DroneOverLoadedException;

import java.util.List;

public interface MedicationService {

    List<MedicationDto> getMedicationItemsByDroneId(long droneId);
    MedicationDto loadMedication(long droneId, MedicationDto medicationDto) throws DroneOverLoadedException, BatteryLowException;
}
