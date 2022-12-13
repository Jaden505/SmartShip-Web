package com.server.server.model;

import javax.persistence.*;

@Entity
@Table(name = "ship")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "location")
    private String location;

    @Column(name = "gps_latitude")
    private String gpsLatitude;

    @Column(name = "gps_longtitude")
    private String gpsLongtitude;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "rpm")
    private int rpm;

    @Column(name = "kw")
    private int kw;

    @Column(name = "water_tank1")
    private int waterTank1;

    @Column(name = "water_tank2")
    private int waterTank2;

    public int getId() {
        return id;
    }

    public String getStatus() {return status;}

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(String gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public String getGpsLongtitude() {
        return gpsLongtitude;
    }

    public void setGpsLongtitude(String gpsLongtitude) {
        this.gpsLongtitude = gpsLongtitude;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public int getKw() {
        return kw;
    }

    public void setKw(int kw) {
        this.kw = kw;
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
}
