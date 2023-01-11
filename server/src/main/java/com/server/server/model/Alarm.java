package com.server.server.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alarm")
public class Alarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "parameter")
    private String parameter;

    @Column(name = "category")
    private String category;

    @Column(name = "setted_up_value")
    private double settedUpValue;

    @Column(name = "ship_id")
    private String shipId;

    public Alarm(String parameter, String category, double settedUpValue, String shipId) {
        this.parameter = parameter;
        this.category = category;
        this.settedUpValue = settedUpValue;
        this.shipId = shipId;
    }

    public Alarm() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getSettedUpValue() {
        return settedUpValue;
    }

    public void setSettedUpValue(double settedUpValue) {
        this.settedUpValue = settedUpValue;
    }

    public String getShipId() {
        return shipId;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }
}
