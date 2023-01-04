package com.server.server.payload.request;

public class ChangePasswordRequest {

    String new_password;

    String old_password;

    public String getNew_password() {
        return new_password;
    }

    public String getOld_password() {
        return old_password;
    }
}
