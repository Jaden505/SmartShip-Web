package com.server.server.repository;

import com.server.server.model.SensorData;
import com.server.server.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
//    List<SensorData> findAllCategories();

    Optional<User> findByUsername(String username);

   Boolean existsByUsername(String username);

   Boolean existsByEmail(String email);

   List<User> findByRoleId(int roleId);


//   List<User> findAllUsers();


}


