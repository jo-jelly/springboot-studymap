package com.studymap.web.dto;

import com.studymap.domain.project.Project;
import lombok.Getter;

@Getter
public class ProjectResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String studyType;
    private Integer member;
    private String state;
    private String area;

    public ProjectResponseDto(Project entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.studyType = entity.getStudyType();
        this.member = entity.getMember();
        this.state = entity.getState();
        this.studyType = entity.getStudyType();
        this.area = entity.getArea();
    }

}
