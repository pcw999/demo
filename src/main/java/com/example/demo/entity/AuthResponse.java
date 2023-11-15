package com.example.demo.entity;

import lombok.Getter;

@Getter
public class AuthResponse {
    private String status;
    private String message;
    private String authToken;
    private UserDTO user;

    public AuthResponse(String status, String message, String authToken, UserDTO user) {
        this.status = status;
        this.message = message;
        this.authToken = authToken;
        this.user = user;
    }
}
