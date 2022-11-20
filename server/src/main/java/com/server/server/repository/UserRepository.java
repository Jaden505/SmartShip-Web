package com.server.server.repository;

import com.server.server.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   User findUserByEmail(String email);

   List<User> findByRoleID(int role_id);
}
