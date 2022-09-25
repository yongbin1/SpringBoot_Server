package com.example.login.domain.auth.service;

import com.example.login.domain.auth.presentation.dto.UserSignInRequest;
import com.example.login.domain.auth.presentation.dto.UserSignUpRequest;
import com.example.login.domain.auth.entity.User;
import com.example.login.domain.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public String signIn(UserSignInRequest request) {

        User user = userRepository.findById(request.getName())
                .orElseThrow(() -> {
                    throw new RuntimeException("존재하지 않는 유저입니다");
        });

        if(request.getPassword().equals(user.getUserPassword())) {
            return user.getUserName();
        } else {
            throw new RuntimeException("비밀번호가 다릅니다");
        }
    }

    public String signUp(UserSignUpRequest request) {

       userRepository.findById(request.getName())
                .ifPresent(m -> {
                    throw new RuntimeException("이미 존재하는 유저입니다");
                });

       User user = User.builder()
               .userName(request.getName())
               .userPassword(request.getPassword())
               .build();
       user = userRepository.save(user);

       return user.getUserName();

    }

}
