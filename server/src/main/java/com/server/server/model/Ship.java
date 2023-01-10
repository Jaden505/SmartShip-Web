package com.server.server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "ship")
public class Ship {
    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "gps_latitude")
    private String gpsLatitude;

    @Column(name = "gps_longtitude")
    private String gpsLongtitude;

    @Column(name = "tank1")
    private Integer tank1;

    @Column(name = "tank2")
    private Integer tank2;

    @JoinColumn(name = "status", nullable = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Status status;

    public String getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTank1() {
        return tank1;
    }

    public Integer getTank2() {
        return tank2;
    }

    public void setTank1(Integer tank1) {
        this.tank1 = tank1;
    }

    public void setTank2(Integer tank2) {
        this.tank2 = tank2;
    }
}
