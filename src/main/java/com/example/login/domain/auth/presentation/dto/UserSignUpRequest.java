package com.example.login.domain.auth.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor
public class UserSignUpRequest {

    private String name;

    private String password;

}
