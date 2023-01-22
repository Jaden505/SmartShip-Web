package com.server.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Random;

@Component
@Entity
@Table(name = "sensor_data_ship")
public class SensorData {

    @Id
    @Column(name = "sensor_id")
    private String sensorId;

    @Column(name = "sensor_group")
    private String group;

    @Column(name = "sensor_name")
    private String sensorName;


    @JoinColumn(name = "ship_id", nullable = true)
    @ManyToOne
    private Ship ship;

    @JsonFormat(pattern = "HH:mm:ss dd/MM/yyyy")
    @Column(name = "ship_time")
    private LocalDateTime time;

    @Column(name = "ship_type")
    private String type;

    @Column(name = "ship_value")
    private String value;

    @Column(name = "ship_unit")
    private String unit;

    @Column(name = "ship_speed")
    private String speed;

    @Column(name = "ship_gps_latitude")
    private String gpsLatitude;

    @Column(name = "ship_gps_longtitude")
    private String gpsLongtitude;

    public SensorData() {
    }

    public SensorData(String sensorId, String group, String sensorName, Ship ship, LocalDateTime time, String type, String value, String unit, String speed, String gpsLatitude, String gpsLongtitude) {
        this();
        this.sensorId = sensorId;
        this.group = group;
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

    //   For testing purposes we create a sample ship
    public static SensorData createSampleSensorData(int id, Ship ship){

        String[] group = {"Fuel", "Sea Conditions", "Motor", "Battery"};

        Random rand = new Random();
        int randomIndex = rand.nextInt(group.length);

        SensorData sensorData = new SensorData();
        sensorData.setSensorId("sensorId" + id);
        sensorData.setGroup(group[randomIndex]);
        sensorData.setSensorName("Sample");
        sensorData.setShip(ship);
        sensorData.setTime(null);
        sensorData.setType(null);
        sensorData.setValue(null);
        sensorData.setUnit(null);
        sensorData.setSpeed(null);
        sensorData.setGpsLatitude(null);
        sensorData.setGpsLongtitude(null);

        return sensorData;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
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

//    @Override
//    public String toString() {
//        return "SensorData{" +
//                "sensorId='" + sensorId + '\'' +
//                ", group='" + group + '\'' +
//                ", sensorName='" + sensorName + '\'' +
//                ", ship=" + ship +
//                ", time=" + time +
//                ", type='" + type + '\'' +
//                ", value='" + value + '\'' +
//                ", unit='" + unit + '\'' +
//                ", speed='" + speed + '\'' +
//                ", gpsLatitude='" + gpsLatitude + '\'' +
//                ", gpsLongtitude='" + gpsLongtitude + '\'' +
//                '}';
//    }
}
