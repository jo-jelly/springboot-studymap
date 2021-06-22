package com.studymap.web.dto;

import com.studymap.domain.posts.Posts;
import com.studymap.domain.studyGroup.StudyGroup;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class StudyGroupDto {

    @Getter
    @NoArgsConstructor
    public static class StudyGroupSaveRequestDto {
        private String title;
        private String content;
        private String author;

        @Builder
        public StudyGroupSaveRequestDto(String title, String content, String author){
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public StudyGroup toEntity() {
            return StudyGroup.builder()
                    .title(title)
                    .content(content)
                    .author(author)
                    .build();
        }
    }
    @Getter
    public static class StudyGroupListResponseDto {
        private Long id;
        private String title;
        private String author;
        private LocalDateTime modifiedDate;

        public StudyGroupListResponseDto(StudyGroup entity){
            this.id = entity.getId();
            this.title = entity.getTitle();
            this.author = entity.getAuthor();
            this.modifiedDate = entity.getModifiedDate();
        }
    }

    @Getter
    public static class StudyGroupResponseDto {
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

    @Getter
    @NoArgsConstructor
    public static class StudyGroupUpdateRequestDto {
        private String title;
        private String content;

        @Builder
        public StudyGroupUpdateRequestDto(String title, String content) {
            this.title = title;
            this.content = content;
        }
    }

    @Getter
    public static class StudyGroupViewResponseDto {
        private Long id;
        private String title;
        private String author;
        private String content;
        private LocalDateTime modifiedDate;
        private int views;

        public StudyGroupViewResponseDto(StudyGroup entity) {
            this.id = entity.getId();
            this.title = entity.getTitle();
            this.author = entity.getAuthor();
            this.content = entity.getContent();
            this.modifiedDate = entity.getModifiedDate();
            this.views = entity.getViews();

        }
    }
}
