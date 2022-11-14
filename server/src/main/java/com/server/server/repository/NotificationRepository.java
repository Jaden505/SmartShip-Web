package com.server.server.repository;

import com.server.server.model.Notification;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NotificationRepository extends JpaRepository<Notification, Integer>{

}

