package com.server.server.herkansing_model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Hotel implements Identifiable {
    @Id
    @GeneratedValue
    private long id;

    private String hotelName;

    private String city;

    @OneToMany(mappedBy = "hotel")
    @JsonBackReference
    private Set<Room> rooms;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {

    }

}
