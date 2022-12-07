package com.server.server.payload.request;

import javax.validation.constraints.*;

public class RegisterRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private int roleID;
    private Integer shipID;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleID() {
        return this.roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public Integer getShipID() {
        return shipID;
    }

    public void setShipID(Integer shipID) {
        this.shipID = shipID;
    }
}
