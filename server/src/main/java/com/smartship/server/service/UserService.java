package com.smartship.server.service;

import com.smartship.server.domain.Role;
import com.smartship.server.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String email, String roleName);
    User getUser(String email);
    List<User> getUsers();

}
