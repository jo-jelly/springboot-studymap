package com.studymap.web.dto;

import com.studymap.domain.studyGroup.StudyGroup;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


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
        private Long userId;
        private String studyType;
        private Integer views;

        @Builder
        public StudyGroupSaveRequestDto(String area, String title, String content, String author, Integer member, String state, Long userId, String studyType, Integer views){
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

        public StudyGroup toEntity() {
            return StudyGroup.builder()
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
    @Getter
    public static class StudyGroupListResponseDto {
        private Long id;
        private String title;
        private String author;
        private String modifiedDate;
        private Integer views;
        private String state;
        private String area;
        private String studyType;

        public StudyGroupListResponseDto(StudyGroup entity){
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

    @Getter
    public static class StudyGroupResponseDto {
        private Long id;
        private String title;
        private String content;
        private String author;
        private String studyType;
        private Integer member;
        private String state;
        private String area;

        public StudyGroupResponseDto(StudyGroup entity) {
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
        private Integer views;
        private Integer member;
        private String area;
        private String state;
        private String studyType;
        private Long userId;


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
            this.member = entity.getMember();
            this.studyType = entity.getStudyType();
        }
    }
}
