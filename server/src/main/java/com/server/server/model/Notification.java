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
    private String shipId;

    @Column(name = "date")
    private Date date;

    @Column(name = "message")
    private String message;

    @Column(name = "unit ")
    private String unit;

    public Notification() {

    }

    public Notification(String parameter, String category, double settedUpValue, String shipId, Date date, String message, String unit) {
        this.title = parameter;
        this.category = category;
        this.value = settedUpValue;
        this.shipId = shipId;
        this.date = date;
        this.message = message;
        this.unit = unit;
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

    public String getShipId() {
        return shipId;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", value=" + value +
                ", shipId='" + shipId + '\'' +
                ", date=" + date +
                ", message='" + message + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
