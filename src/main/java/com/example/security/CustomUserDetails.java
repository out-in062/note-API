package com.example.security;

import
import jakarta.annotation.Nullable;
import org.apache.catalina.User;

public class CustomUserDetails {
    private final User user;

    public CustomUserDetails(User user) {

    }

    @Override
    public @Nullable String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}
