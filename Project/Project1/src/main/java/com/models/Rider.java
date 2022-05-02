package com.models;

import javax.persistence.*;

@Entity
@Table(name="`Rider`")
public class Rider {

    @Column(name = "id")
    @Id
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="carNumber")
    private String carNumber;

    @Column(name="phoneNumber")
    private String phoneNumber;

    @Column(name="startPoint")
    private String startPoint;

    @Column(name="destination")
    private String destination;

    @Column(name = "available")
    private boolean available;

    Rider(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", startPoint='" + startPoint + '\'' +
                ", destination='" + destination + '\'' +
                ", available=" + available +
                '}';
    }
}
