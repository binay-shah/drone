package com.musala.assignment.entity;

import com.example.drone.dto.DroneState;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "drones")
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String serialNumber;
    private String model;
    private double weight;
    private int batteryCapacity;
    @Enumerated(EnumType.STRING)
    private DroneState state;
    @OneToMany(mappedBy = "drone")
    private Set<com.example.drone.entity.Medication> items;

    public Drone(Long id, String serialNumber, String model, double weight, int batteryCapacity, DroneState state) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.model = model;
        this.weight = weight;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
    }

    public Drone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public DroneState getState() {
        return state;
    }

    public void setState(DroneState state) {
        this.state = state;
    }
}

