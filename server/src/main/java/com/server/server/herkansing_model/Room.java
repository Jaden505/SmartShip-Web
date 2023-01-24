package com.server.server.herkansing_model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Room implements Identifiable {
    @Id
    @GeneratedValue
    private long id;

    private String roomName;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Hotel hotel;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {

    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
