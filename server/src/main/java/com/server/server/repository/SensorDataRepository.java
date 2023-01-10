package com.server.server.repository;

import com.server.server.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SensorDataRepository extends JpaRepository<SensorData, Integer> {
    List<SensorData> findByShipId(String shipId);

    @Query(value = "select distinct s.group" +
            " from SensorData s")
    public List<String> getCategories();
}
