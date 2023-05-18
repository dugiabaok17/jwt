package com.example.demo.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SignUpRequest {
    private String username;
    private String password;
    private String email;
    private String phone;
    private Set<String> listRoles;
}
