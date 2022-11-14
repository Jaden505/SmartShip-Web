package com.server.server.repository;

import com.server.server.model.Alarm;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AlarmRepository extends JpaRepository<Alarm, Integer>{

}

