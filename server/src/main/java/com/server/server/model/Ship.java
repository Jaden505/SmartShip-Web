package com.server.server.model;

import javax.persistence.*;

@Entity
@Table(name = "ship")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "status")
    private String status;

    @Column(name = "location")
    private String location;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "water_tank1")
    private int waterTank1;

    @Column(name = "water_tank2")
    private int waterTank2;

    @Column(name = "engine_temperature1")
    private double engineTemperature1;

    @Column(name = "engine_temperature2")
    private double engineTemperature2;

    @Column(name = "rpm")
    private int rpm;

    @Column(name = "kw")
    private int kW;


    public Ship(String status, String location, String origin, String destination, int waterTank1, int waterTank2,
                double engineTemperature1, double engineTemperature2, int rpm, int kW) {
        this.status = status;
        this.location = location;
        this.origin = origin;
        this.destination = destination;
        this.waterTank1 = waterTank1;
        this.waterTank2 = waterTank2;
        this.engineTemperature1 = engineTemperature1;
        this.engineTemperature2 = engineTemperature2;
        this.kW = kW;
        this.rpm = rpm;
    }

    public Ship() {

    }



    public double getEngineTemperature1() {
        return engineTemperature1;
    }

    public void setEngineTemperature1(double engineTemperature1) {
        this.engineTemperature1 = engineTemperature1;
    }

    public double getEngineTemperature2() {
        return engineTemperature2;
    }

    public void setEngineTemperature2(double engineTemperature2) {
        this.engineTemperature2 = engineTemperature2;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public int getkW() {
        return kW;
    }

    public void setkW(int kW) {
        this.kW = kW;
    }

    public int getWaterTank1() {
        return waterTank1;
    }

    public void setWaterTank1(int waterTank1) {
        this.waterTank1 = waterTank1;
    }

    public int getWaterTank2() {
        return waterTank2;
    }

    public void setWaterTank2(int waterTank2) {
        this.waterTank2 = waterTank2;
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Ship [id=" + id + "]";
    }
}
