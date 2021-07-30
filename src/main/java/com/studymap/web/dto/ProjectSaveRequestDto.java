package com.studymap.web.dto;

import com.studymap.domain.project.Project;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProjectSaveRequestDto {
    private String area;
    private String title;
    private String content;
    private String author;
    private Integer member;
    private String state;
    private Long userId;
    private String studyType;
    private Integer views;

    @Builder
    public ProjectSaveRequestDto(String area, String title, String content, String author, Integer member, String state, Long userId, String studyType, Integer views) {
        this.area = area;
        this.title = title;
        this.content = content;
        this.author = author;
        this.member = member;
        this.state = state;
        this.userId = userId;
        this.studyType = studyType;
        this.views = views;
    }

    public Project toEntity() {
        return Project.builder()
                .area(area)
                .title(title)
                .content(content)
                .author(author)
                .member(member)
                .state(state)
                .userId(userId)
                .studyType(studyType)
                .views(views)
                .build();
    }

}
