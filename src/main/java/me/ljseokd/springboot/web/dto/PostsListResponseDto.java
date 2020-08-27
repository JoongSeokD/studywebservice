package me.ljseokd.springboot.web.dto;

import me.ljseokd.springboot.domain.posts.Posts;

import java.time.LocalDateTime;

public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts enttiy) {
        this.id = enttiy.getId();
        this.title = enttiy.getTitle();
        this.author = enttiy.getAuthor();
        this.modifiedDate = enttiy.getModifiedDate();
    }
}
