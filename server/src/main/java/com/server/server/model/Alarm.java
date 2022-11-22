package com.server.server.model;

import javax.persistence.*;

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

    @Column(name = "value_since_last_update")
    private double valueSinceLastUpdate;

    @Column(name = "setted_up_value")
    private double settedUpValue;

    @Column(name = "ship_id")
    private int ship_id;


//    public Notification(Long id, String parameter, String category, double valueSinceLastUpdate, double settedUpValue, int ship_id) {
//        this.id = id;
//        this.parameter = parameter;
//        this.category = category;
//        this.valueSinceLastUpdate = valueSinceLastUpdate;
//        this.settedUpValue = settedUpValue;
//        this.ship_id = ship_id;
//    }
    public Alarm(String parameter, String category, double valueSinceLastUpdate, double settedUpValue, int ship_id) {
        this.parameter = parameter;
        this.category = category;
        this.valueSinceLastUpdate = valueSinceLastUpdate;
        this.settedUpValue = settedUpValue;
        this.ship_id = ship_id;
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

    public double getValueSinceLastUpdate() {
        return valueSinceLastUpdate;
    }

    public void setValueSinceLastUpdate(double valueSinceLastUpdate) {
        this.valueSinceLastUpdate = valueSinceLastUpdate;
    }

    public double getSettedUpValue() {
        return settedUpValue;
    }

    public void setSettedUpValue(double settedUpValue) {
        this.settedUpValue = settedUpValue;
    }

    public int getShip_id() {
        return ship_id;
    }

    public void setShip_id(int ship_id) {
        this.ship_id = ship_id;
    }
}
