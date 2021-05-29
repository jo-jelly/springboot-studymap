package com.studymap.web.dto;

import com.studymap.domain.posts.Posts;
import com.studymap.domain.studyGroup.StudyGroup;
import lombok.Getter;

@Getter
public class StudyGroupResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public StudyGroupResponseDto(StudyGroup entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
