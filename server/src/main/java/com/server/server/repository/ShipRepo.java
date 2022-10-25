package com.server.server.repository;

import com.server.server.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipRepo extends JpaRepository<Ship, Long> {

}