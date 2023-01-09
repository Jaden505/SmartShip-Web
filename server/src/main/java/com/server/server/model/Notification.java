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

    @Column(name = "parameter")
    private String title;

    @Column(name = "category")
    private String category;

    @Column(name = "value")
    private double value;

    @Column(name = "ship_id")
    private String ship_id;

    @Column(name = "date")
    private Date date;

    @Column(name = "message")
    private String message;

    @Column(name = "unit ")
    private String unit;

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCategory() {
        return category;
    }

    public double getValue() {
        return value;
    }


    public String getShip_id() {
        return ship_id;
    }

}
