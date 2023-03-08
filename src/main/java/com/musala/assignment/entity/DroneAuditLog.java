package com.musala.assignment.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "drone_audit_logs")
public class DroneAuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long droneId;
    private String serialNumber;
    private int batteryLevel;
    private Date createdDate;

    public DroneAuditLog(Long id, Long droneId, String serialNumber, int batteryLevel, Date createdDate) {
        this.id = id;
        this.droneId = droneId;
        this.serialNumber = serialNumber;
        this.batteryLevel = batteryLevel;
        this.createdDate = createdDate;
    }

    public DroneAuditLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDroneId() {
        return droneId;
    }

    public void setDroneId(Long droneId) {
        this.droneId = droneId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
