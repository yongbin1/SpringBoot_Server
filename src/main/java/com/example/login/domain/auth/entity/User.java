package com.example.login.domain.auth.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Builder
@AllArgsConstructor
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    private String userName;

    private String userPassword;

}
