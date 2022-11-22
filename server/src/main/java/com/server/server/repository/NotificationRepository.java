package com.server.server.repository;

import com.server.server.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotificationRepository extends JpaRepository<Notification, Integer>{
}

