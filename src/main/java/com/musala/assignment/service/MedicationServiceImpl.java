package com.musala.assignment.service;


import com.musala.assignment.dto.MedicationDto;
import com.musala.assignment.entity.Drone;
import com.musala.assignment.entity.Medication;
import com.musala.assignment.exception.BatteryLowException;
import com.musala.assignment.exception.DroneOverLoadedException;
import com.musala.assignment.exception.ResourceNotFoundException;
import com.musala.assignment.repository.DroneRepository;
import com.musala.assignment.repository.MedicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicationServiceImpl implements MedicationService{

    private MedicationRepository medicationRepository;
    private DroneRepository droneRepository;

    public MedicationServiceImpl(MedicationRepository medicationRepository, DroneRepository droneRepository) {
        this.medicationRepository = medicationRepository;
        this.droneRepository = droneRepository;
    }

    @Override
    public List<MedicationDto> getMedicationItemsByDroneId(long droneId) {
          List<Medication> medications = medicationRepository.findByDroneId(droneId);
          return medications.stream().map(medication -> mapToDTO(medication)).collect(Collectors.toList());
    }

    @Override
    public MedicationDto loadMedication(long droneId, MedicationDto medicationDto) throws DroneOverLoadedException, BatteryLowException {

        Medication medication = mapToEntity(medicationDto);

        // retrieve post entity by id
        Drone drone = droneRepository.findById(droneId).orElseThrow(
                () -> new ResourceNotFoundException("Drone", "id", droneId));

        if(drone.getBatteryCapacity() < 25){
            throw new BatteryLowException("Battery low");
        }
        if(getTotalMedicationWeightByDroneId(droneId) + medicationDto.getWeight() > drone.getWeight()){
            throw new DroneOverLoadedException("Drone overloaded");
        }

        // set post to comment entity
        medication.setDrone(drone);

        // comment entity to DB
        Medication newMedication =  medicationRepository.save(medication);

        return mapToDTO(newMedication);


    }

    private MedicationDto mapToDTO(Medication medication){
        MedicationDto medicationDto = new MedicationDto();
        medicationDto.setId(medication.getId());
        medicationDto.setName(medication.getName());
        medicationDto.setCode(medication.getCode());
        medicationDto.setImage(medication.getImage());
        return  medicationDto;
    }

    private Medication mapToEntity(MedicationDto medicationDto){
        Medication medication = new Medication();
        medication.setId(medicationDto.getId());
        medication.setName(medicationDto.getName());
        medication.setCode(medicationDto.getCode());
        medication.setImage(medicationDto.getImage());
        return  medication;
    }

    private double getTotalMedicationWeightByDroneId(Long droneId){
        List<Medication> medications = medicationRepository.findByDroneId(droneId);
        double totalWeight  = 0;
        for(Medication medication : medications){
            totalWeight += medication.getWeight();
        }
        return totalWeight;
    }


}
