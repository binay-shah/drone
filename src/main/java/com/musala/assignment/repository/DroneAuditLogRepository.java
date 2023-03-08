package com.musala.assignment.repository;


import com.musala.assignment.entity.DroneAuditLog;
import org.springframework.data.repository.CrudRepository;

public interface DroneAuditLogRepository extends CrudRepository<DroneAuditLog, Long> {
}
