package com.server.server.model;

import javax.persistence.*;

@Entity
@Table(name = "engine")
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rpm_good")
    private int rpmGood;

    @Column(name = "rpm_warning")
    private int rpmWarning;

    @Column(name = "rpm_critical")
    private int rpmCritical;

    @Column(name = "kw_good")
    private int kwGood;

    @Column(name = "kw_warning")
    private int kwWarning;

    @Column(name = "kw_critical")
    private int kwCritical;

    @Column(name = "temperature")
    private double temperature;

    @Column(name = "id_ship")
    private int shipId;

    public Engine(int id, int rpmGood, int rpmWarning, int rpmCritical, int kwGood, int kwWarning, int kwCritical,
                  double temperature, int shipId) {
        this.id = id;
        this.rpmGood = rpmGood;
        this.rpmWarning = rpmWarning;
        this.rpmCritical = rpmCritical;
        this.kwGood = kwGood;
        this.kwWarning = kwWarning;
        this.kwCritical = kwCritical;
        this.temperature = temperature;
        this.shipId = shipId;
    }

    public Engine() {
    }

    public int getKwGood() {
        return kwGood;
    }

    public void setKwGood(int kwGood) {
        this.kwGood = kwGood;
    }

    public int getKwWarning() {
        return kwWarning;
    }

    public void setKwWarning(int kwWarning) {
        this.kwWarning = kwWarning;
    }

    public int getKwCritical() {
        return kwCritical;
    }

    public void setKwCritical(int kwCritical) {
        this.kwCritical = kwCritical;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRpmGood() {
        return rpmGood;
    }

    public void setRpmGood(int rpmGood) {
        this.rpmGood = rpmGood;
    }

    public int getRpmWarning() {
        return rpmWarning;
    }

    public void setRpmWarning(int rpmWarning) {
        this.rpmWarning = rpmWarning;
    }

    public int getRpmCritical() {
        return rpmCritical;
    }

    public void setRpmCritical(int rpmCritical) {
        this.rpmCritical = rpmCritical;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    @Override
    public String toString() {
        return "Ship [id=" + id + "]";
    }

}

