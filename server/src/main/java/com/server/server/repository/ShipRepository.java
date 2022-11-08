package com.server.server.repository;

import com.server.server.entity.Role;
import com.server.server.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

}
