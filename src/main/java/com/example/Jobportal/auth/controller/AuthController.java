package com.example.Jobportal.auth.controller;

import com.example.Jobportal.auth.domain.*;
import com.example.Jobportal.auth.security.JwtTokenUtil;
import com.example.Jobportal.auth.service.CreatorService;
import com.example.Jobportal.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    private final JwtTokenUtil jwtTokenUtil;

    private final CreatorService creatorService;

    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDto request) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.username(), request.password());
        Authentication authentication = authenticationManager.authenticate(token);

        org.springframework.security.core.userdetails.User userDetails = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        User user = userService.getByUsername(userDetails.getUsername());

        String accessToken = jwtTokenUtil.generateAccessToken(user);
        String refreshToken = jwtTokenUtil.generateRefreshToken(user);

        LoginResponse response = new LoginResponse(UserResponse.fromEntity(user),accessToken,refreshToken);


//        Map<String, String> tokens = new HashMap<>();
//        tokens.put("access_token", accessToken);
//        tokens.put("refresh_token", refreshToken);
//
//        Map<User,Map<String,String>> data = new HashMap<>();
//        data.put(user,tokens);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("refresh")
    public ResponseEntity<Map<String, String>> refresh(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String refreshToken = authorizationHeader.substring("Bearer ".length());
            if (jwtTokenUtil.validate(refreshToken)) {
                org.springframework.security.core.userdetails.User userDetails = (org.springframework.security.core.userdetails.User)
                        userService.loadUserByUsername(jwtTokenUtil.getUserName(refreshToken));
                User user = userService.getByUsername(userDetails.getUsername());

                String accessToken = jwtTokenUtil.generateAccessToken(user);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", accessToken);

                return ResponseEntity.ok().body(tokens);
            }
        }

        return ResponseEntity.badRequest().body(null);
    }

    @PostMapping("register")
    public User register(@RequestBody RegistrationDto request) {
        return creatorService.create(request);
    }

}
