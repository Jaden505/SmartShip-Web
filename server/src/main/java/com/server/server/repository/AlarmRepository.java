package com.server.server.repository;

import com.server.server.model.Alarm;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AlarmRepository extends JpaRepository<Alarm, Integer>{
}

