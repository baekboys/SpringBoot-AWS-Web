package com.baek.springboot.web;

import com.baek.springboot.service.posts.PostService;
import com.baek.springboot.web.dto.PostSaveRequestDto;
import com.baek.springboot.web.dto.PostsResponseDto;
import com.baek.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto requestDto) {
        return postService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto select(@PathVariable Long id) {
        return postService.findById(id);
    }
}
