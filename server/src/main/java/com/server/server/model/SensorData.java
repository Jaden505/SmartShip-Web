package com.server.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Component
@Entity
@Table(name = "sensor_data")
public class SensorData {

    @Id
    @Column(name = "sensor_id")
    private String sensorId;

    @Column(name = "category")
    private String category;

    @Column(name = "sensor_name")
    private String sensorName;

//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)


    @Nullable
    @JoinColumn(name = "ship_id", nullable = true)
    private String ship;

    @JsonFormat(pattern = "HH:mm:ss dd/MM/yyyy")
    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "type")
    private String type;

    @Column(name = "value")
    private String value;

    @Column(name = "unit")
    private String unit;

    @Column(name = "speed")
    private String speed;

    @Column(name = "gps_latitude")
    private String gpsLatitude;

    @Column(name = "gps_longtitude")
    private String gpsLongtitude;

    protected SensorData() {
    }

    public SensorData(String sensorId, String category, String sensorName, String ship, LocalDateTime time, String type, String value, String unit, String speed, String gpsLatitude, String gpsLongtitude) {
        this();
        this.sensorId = sensorId;
        this.category = category;
        this.sensorName = sensorName;
        this.ship = ship;
        this.time = time;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.speed = speed;
        this.gpsLatitude = gpsLatitude;
        this.gpsLongtitude = gpsLongtitude;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getShip() {
        return ship;
    }

    public void setShip(String ship) {
        this.ship = ship;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
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


    @Override
    public String toString() {
        return "SensorData{" +
                "sensorId='" + sensorId + '\'' +
                ", category='" + category + '\'' +
                ", sensorName='" + sensorName + '\'' +
                ", ship=" + ship +
                ", time=" + time +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", unit='" + unit + '\'' +
                ", speed='" + speed + '\'' +
                ", gpsLatitude='" + gpsLatitude + '\'' +
                ", gpsLongtitude='" + gpsLongtitude + '\'' +
                '}';
    }

}
