package com.server.server.model;

import javax.persistence.*;

@Entity
@Table(name = "watertank")
public class Chart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "amount_in_liters")
    private int amountInLiters;

    @Column(name = "ship_id")
    private int shipId;

    public Chart(int amountInLiters, int shipId) {
        this.amountInLiters = amountInLiters;
        this.shipId = shipId;
    }

    public Chart() {

    }

    public long getId() {
        return id;
    }

    public int getAmountInLiters() {
        return amountInLiters;
    }

    public void setAmountInLiters(int amountInLiters) {
        this.amountInLiters = amountInLiters;
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
