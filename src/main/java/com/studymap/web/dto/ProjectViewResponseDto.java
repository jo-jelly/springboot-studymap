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
    private Integer views;
    private Integer member;
    private String area;
    private String state;
    private String studyType;
    private Long userId;

    public ProjectViewResponseDto(Project entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.area = entity.getArea();
        this.views = entity.getViews();
        this.member = entity.getMember();
        this.state = entity.getState();
        this.userId = entity.getUserId();
        this.studyType = entity.getStudyType();
        this.modifiedDate = entity.getModifiedDate();
    }

}
