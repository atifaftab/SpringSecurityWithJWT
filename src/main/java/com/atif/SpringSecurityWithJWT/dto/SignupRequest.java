package com.atif.SpringSecurityWithJWT.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SignupRequest {
    private String username;
    private String password;
}
