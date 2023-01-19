package com.server.server.repository;

import com.server.server.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface is used to define the database operations
// It extends the JpaRepository interface which provides the basic CRUD operations
// The interface also provides the ability to define custom queries
// The interface is used by the NotificationController class to perform the database operations
// We pass the Notification class as the type parameter and the id type as the second parameter
public interface NotificationRepository extends JpaRepository<Notification, Integer>{
}

