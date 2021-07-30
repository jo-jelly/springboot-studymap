package com.studymap.web.dto;

import com.studymap.domain.project.Project;
import lombok.Getter;

@Getter
public class ProjectListResponseDto {
    private Long id;
    private String title;
    private String author;
    private String modifiedDate;
    private Integer views;
    private String state;
    private String area;
    private String studyType;

    public ProjectListResponseDto(Project entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
        this.views = entity.getViews();
        this.state = entity.getState();
        this.area = entity.getArea();
        this.studyType = entity.getStudyType();
    }

}
