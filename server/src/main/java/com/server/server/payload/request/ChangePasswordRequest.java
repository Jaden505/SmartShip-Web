package com.server.server.payload.request;

public class ChangePasswordRequest {

    String new_password;

    String old_password;

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }
}
