package com.server.server.repository;

import com.server.server.model.Notification;
import com.server.server.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface NotificationRepository extends JpaRepository<Notification, Integer>{

}

