package com.musala.assignment.service;


import com.musala.assignment.entity.Drone;
import com.musala.assignment.entity.DroneAuditLog;
import com.musala.assignment.repository.DroneAuditLogRepository;
import com.musala.assignment.repository.DroneRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ScheduledTaskService {

    private DroneRepository droneRepository;
    private DroneAuditLogRepository droneAuditLogRepository;

    public ScheduledTaskService(DroneRepository droneRepository, DroneAuditLogRepository droneAuditLogRepository) {
        this.droneRepository = droneRepository;
        this.droneAuditLogRepository = droneAuditLogRepository;
    }

    @Scheduled(fixedDelay = 5000)
    public void execute() {
        // some logic that will be executed on a schedule
        System.out.println("Code is being executed...");
        List<Drone> droneList = (List<Drone>)droneRepository.findAll();
        for (Drone drone : droneList){
            DroneAuditLog auditLog = new DroneAuditLog();
            auditLog.setBatteryLevel(drone.getBatteryCapacity());
            auditLog.setSerialNumber(drone.getSerialNumber());;
            auditLog.setDroneId(drone.getId());
            auditLog.setCreatedDate(new Date());
            droneAuditLogRepository.save(auditLog);
        }



    }
}
