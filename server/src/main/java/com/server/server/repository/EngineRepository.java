package com.server.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.server.server.model.Engine;

@Repository
public interface EngineRepository extends JpaRepository<Engine, Integer> {

}
