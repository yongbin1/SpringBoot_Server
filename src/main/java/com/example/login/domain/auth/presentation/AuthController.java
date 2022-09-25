package com.example.login.domain.auth.presentation;

import com.example.login.domain.auth.presentation.dto.UserSignInRequest;
import com.example.login.domain.auth.presentation.dto.UserSignUpRequest;
import com.example.login.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/sign-up")
    public String userSignUp(
            @RequestBody UserSignUpRequest request
    ) {
        return authService.signUp(request);
    }

    @PostMapping("/sign-in")
    public String userSignIn(
            @RequestBody UserSignInRequest request
    ) {
        return authService.signIn(request);
    }

}
