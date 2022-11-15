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

    public Ship(String status, String location, String origin, String destination, int waterTank1, int waterTank2) {
        this.status = status;
        this.location = location;
        this.origin = origin;
        this.destination = destination;
        this.waterTank1 = waterTank1;
        this.waterTank2 = waterTank2;
    }

    public Ship() {

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
