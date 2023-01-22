package com.server.server.repository;

import com.server.server.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SensorDataRepository extends JpaRepository<SensorData, String> {
    List<SensorData> findByShipId(String shipId);

    List<SensorData> findAll();

    @Query(value = "select distinct s.group" +
            " from SensorData s")
    public List<String> getCategories();

    @Query(value = "select distinct s.sensorName" +
            " from SensorData s where s.group = 'Motor' ")
    public List<String> getSensorNameByMotor();

    @Query(value = "select distinct s.sensorName" +
            " from SensorData s where s.group = 'Sea Conditions' ")
    public List<String> getSensorNameBySeaConditions();

    @Query(value = "select distinct s.sensorName" +
            " from SensorData s where s.group = 'Fuel' ")
    public List<String> getSensorNameByFuel();

    @Query(value = "select distinct s.sensorName" +
            " from SensorData s where s.group = 'Battery' ")
    public List<String> getSensorNameByBattery();
}
