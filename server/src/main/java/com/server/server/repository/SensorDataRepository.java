package com.server.server.repository;

import com.server.server.model.SensorData;
import com.server.server.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SensorDataRepository extends JpaRepository<SensorData, Integer> {
    List<SensorData> findByShipId(String shipId);

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

    @Query(value = "select distinct s.value" +
            " from SensorData s where s.group = :group and s.sensorName = :sensorName and s.ship = :ship")
    public List<String> getSensorValue(@Param("group") String group, @Param("sensorName")String sensorName, @Param("ship") Ship ship);

    @Query(value = "select distinct s.sensorName" +
            " from SensorData s where s.group = :group")
    public List<String> getSensorName(@Param("group") String group);
}
