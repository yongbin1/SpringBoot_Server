package com.example.login.domain.post.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor
public class CreatePostRequest {

    private String title;

    private String content;

    private String weather;

}
