package com.musala.assignment.entity;

import javax.persistence.*;

@Entity
@Table(name = "medications")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double weight;
    private String code;
    private String image;

    @ManyToOne
    @JoinColumn(name="drone_id", nullable=false)
    private Drone drone;

    public Medication(Long id, String name, double weight, String code, String image, Drone drone) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.image = image;
        this.drone = drone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medication() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }
}
