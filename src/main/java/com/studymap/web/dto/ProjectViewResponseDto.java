package com.studymap.web.dto;

import com.studymap.domain.project.Project;
import lombok.Getter;

@Getter
public class ProjectViewResponseDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    private String modifiedDate;
    private int views;

    public ProjectViewResponseDto(Project entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.content = entity.getContent();
        this.modifiedDate = entity.getModifiedDate();
        this.views = entity.getViews();

    }

}
