package com.studymap.web.dto;

import com.studymap.domain.project.Project;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProjectSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public ProjectSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Project toEntity() {
        return Project.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
