package com.baek.springboot.service.posts;

import com.baek.springboot.domain.posts.Posts;
import com.baek.springboot.domain.posts.PostsRepository;
import com.baek.springboot.web.dto.PostListResponseDto;
import com.baek.springboot.web.dto.PostSaveRequestDto;
import com.baek.springboot.web.dto.PostsResponseDto;
import com.baek.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("해당사용자가 없습니다. id=" + id) );

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {;
        Posts entity = postsRepository.findById(id).orElseThrow( () ->  new IllegalArgumentException("해당사용자가 없습니다. id=" + id) );

        return new PostsResponseDto(entity);
    }

    @Transactional
    public List<PostListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream().map(PostListResponseDto::new).collect(Collectors.toList());
    }

}
