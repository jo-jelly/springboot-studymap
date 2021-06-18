package com.studymap.web.dto;

import com.studymap.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsViewResponseDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    private LocalDateTime modifiedDate;

    public PostsViewResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.content = entity.getContent();
        this.modifiedDate = entity.getModifiedDate();

    }

}
