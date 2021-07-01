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
        private String area;
        private String title;
        private String content;
        private String author;
        private Integer member;
        private String state;
        private long userId;

        @Builder
        public StudyGroupSaveRequestDto(String area, String title, String content, String author, Integer member, String state, long userId){
            this.area = area;
            this.title = title;
            this.content = content;
            this.author = author;
            this.member = member;
            this.state = state;
            this.userId = userId;
        }

        public StudyGroup toEntity() {
            return StudyGroup.builder()
                    .area(area)
                    .title(title)
                    .content(content)
                    .author(author)
                    .member(member)
                    .state(state)
                    .userId(userId)
                    .build();
        }
    }
    @Getter
    public static class StudyGroupListResponseDto {
        private Long id;
        private String title;
        private String author;
        private String modifiedDate;
        private Integer views;
        private String state;
        private String area;

        public StudyGroupListResponseDto(StudyGroup entity){
            this.id = entity.getId();
            this.title = entity.getTitle();
            this.author = entity.getAuthor();
            this.modifiedDate = entity.getModifiedDate();
            this.views = entity.getViews();
            this.state = entity.getState();
            this.area = entity.getArea();
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
        private String modifiedDate;
        private int views;
        private String area;
        private String state;
        private long userId;

        public StudyGroupViewResponseDto(StudyGroup entity) {
            this.id = entity.getId();
            this.title = entity.getTitle();
            this.author = entity.getAuthor();
            this.content = entity.getContent();
            this.modifiedDate = entity.getModifiedDate();
            this.views = entity.getViews();
            this.area = entity.getArea();
            this.state = entity.getState();
            this.userId = entity.getUserId();
        }
    }
}
