package com.example.Jobportal.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private UserResponse user;
    private String accessToken;
    private String refreshToken;
}
