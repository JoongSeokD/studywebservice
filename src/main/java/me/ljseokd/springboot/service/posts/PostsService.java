package me.ljseokd.springboot.service.posts;

import lombok.RequiredArgsConstructor;
import me.ljseokd.springboot.domain.posts.Posts;
import me.ljseokd.springboot.domain.posts.PostsRepository;
import me.ljseokd.springboot.web.PostsResponseDto;
import me.ljseokd.springboot.web.dto.PostsSaveRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public Long update(Long id, PostsSaveRequestDto requestDto) {
        Posts posts = getPosts(id);
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    private Posts getPosts(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        return posts;
    }

    public PostsResponseDto findById(Long id) {
        return new PostsResponseDto(getPosts(id));
    }
}
