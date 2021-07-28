package com.studymap.web.dto;

import com.studymap.domain.project.Project;
import lombok.Getter;

@Getter
public class ProjectListResponseDto {
    private Long id;
    private String title;
    private String author;
    private String modifiedDate;

    public ProjectListResponseDto(Project entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();

    }

}
