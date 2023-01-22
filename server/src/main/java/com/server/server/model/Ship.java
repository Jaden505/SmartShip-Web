package com.server.server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "ship")
public class Ship {

    @Id
    @Column(name = "ship_id")
    private String id;

    @Column(name = "name")
    private String name;

//    @JoinColumn(name = "status", nullable = true)
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private String status;

    @Column(name = "gps_latitude")
    private String gpsLatitude;

    @Column(name = "gps_longtitude")
    private String gpsLongtitude;

    @Column(name = "tank1")
    private Integer tank1;

    @Column(name = "tank2")
    private Integer tank2;

    //   For testing purposes we create a sample ship
    public static Ship createSampleShip(int id){

        Ship ship = new Ship();
        ship.setId("ship" + id);
        ship.setName("Ship " + id);
        ship.setGpsLatitude("10.0");
        ship.setGpsLongtitude("10.0");
        ship.setStatus("ACTIVE");
        ship.setTank1(100);
        ship.setTank2(100);
        return ship;

    }

    public Ship() {
    }

    public Ship(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

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
