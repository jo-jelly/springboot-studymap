package com.studymap.web.dto;

import com.studymap.domain.project.Project;
import lombok.Getter;

@Getter
public class ProjectResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public ProjectResponseDto(Project entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }

}
