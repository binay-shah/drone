package com.musala.assignment.repository;


import com.musala.assignment.entity.Medication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface MedicationRepository extends CrudRepository<Medication, Long> {
    List<Medication> findByDroneId(long droneId);
}
