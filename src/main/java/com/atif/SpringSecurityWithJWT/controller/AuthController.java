package com.atif.SpringSecurityWithJWT.controller;

import com.atif.SpringSecurityWithJWT.dto.AuthRequest;
import com.atif.SpringSecurityWithJWT.dto.SignupRequest;
import com.atif.SpringSecurityWithJWT.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest signupRequest) {
        return authService.signup(signupRequest);
    }
}
