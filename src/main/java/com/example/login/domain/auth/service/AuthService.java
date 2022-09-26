package com.example.login.domain.auth.service;

import com.example.login.domain.auth.exception.PasswordWrongException;
import com.example.login.domain.auth.exception.UserAlreadyExistsException;
import com.example.login.domain.auth.exception.UserNotFoundException;
import com.example.login.domain.auth.presentation.dto.UserSignInRequest;
import com.example.login.domain.auth.presentation.dto.UserSignUpRequest;
import com.example.login.domain.auth.entity.User;
import com.example.login.domain.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public String signIn(UserSignInRequest request) {

        User user = userRepository.findById(request.getName())
                .orElseThrow(UserNotFoundException::new);

        if(request.getPassword().equals(user.getUserPassword())) {
            return user.getUserName();
        } else {
            throw new PasswordWrongException();
        }
    }

    @Transactional
    public String signUp(UserSignUpRequest request) {

       userRepository.findById(request.getName())
                .ifPresent(m -> {
                    throw new UserAlreadyExistsException();
                });

       User user = User.builder()
               .userName(request.getName())
               .userPassword(request.getPassword())
               .posts(new ArrayList<>())
               .build();
       user = userRepository.save(user);

       return user.getUserName();

    }

}
