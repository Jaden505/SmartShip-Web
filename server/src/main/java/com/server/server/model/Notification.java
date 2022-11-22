package com.server.server.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private Date date;

    @Column(name = "message")
    private String message;

    @Column(name = "temperature")
    private double temperature;


    //    public Notification(Long id, String parameter, String category, double valueSinceLastUpdate, double settedUpValue, int ship_id) {
//        this.id = id;
//        this.parameter = parameter;
//        this.category = category;
//        this.valueSinceLastUpdate = valueSinceLastUpdate;
//        this.settedUpValue = settedUpValue;
//        this.ship_id = ship_id;
//    }
    public Notification() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
