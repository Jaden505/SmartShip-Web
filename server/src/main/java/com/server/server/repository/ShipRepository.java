package com.server.server.repository;

import com.server.server.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, String> {
    
    List<Ship> findShipById(int shipId);
    List<Ship> findShipById(String shipId);


}
