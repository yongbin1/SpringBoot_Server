package com.example.login.domain.post.presentation;

import com.example.login.domain.post.presentation.dto.CreatePostRequest;
import com.example.login.domain.post.presentation.dto.ModifyPostRequest;
import com.example.login.domain.post.presentation.dto.response.PostListResponse;
import com.example.login.domain.post.presentation.dto.response.PostResponse;
import com.example.login.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{user-id}")
    public Long createPost(
            @PathVariable("user-id") String userId,
            @RequestBody CreatePostRequest request
    ) {
        return postService.createPost(userId, request);
    }

    @PatchMapping("/{post-id}")
    public Long modifyPost(
            @PathVariable("post-id") Long postId,
            @RequestBody ModifyPostRequest request
    ) {
        return postService.modifyPost(postId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{post-id}")
    public void deletePost(
            @PathVariable("post-id") Long postId
    ) {
        postService.deletePost(postId);
    }

    @GetMapping("/{post-id}")
    public PostResponse getPost(
            @PathVariable("post-id") Long postId
    ) {
        return postService.getPost(postId);
    }

    @GetMapping("/")
    public PostListResponse getPostList() {
        return postService.getPostList();
    }

}
