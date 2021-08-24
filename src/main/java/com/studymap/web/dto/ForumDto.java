package com.studymap.web.dto;

import com.studymap.domain.forum.Forum;
import com.studymap.domain.studyGroup.StudyGroup;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class ForumDto {

    @Getter
    @NoArgsConstructor
    public static class ForumSaveRequestDto {
        private String title;
        private String content;
        private String author;
        private Integer views;
        private Long userId;

        @Builder
        public ForumSaveRequestDto(String title, String content, String author, Integer views, Long userId){

            this.title = title;
            this.content = content;
            this.author = author;
            this.views = views;
            this.userId = userId;
        }

        public Forum toEntity() {
            return Forum.builder()
                    .title(title)
                    .content(content)
                    .author(author)
                    .views(views)
                    .userId(userId)
                    .build();
        }
    }
    @Getter
    public static class ForumListResponseDto {
        private Long id;
        private String title;
        private String author;
        private String modifiedDate;
        private Integer views;

        public ForumListResponseDto(Forum entity){
            this.id = entity.getId();
            this.title = entity.getTitle();
            this.author = entity.getAuthor();
            this.modifiedDate = entity.getModifiedDate();
            this.views = entity.getViews();
        }
    }

    @Getter
    public static class ForumResponseDto {
        private Long id;
        private String title;
        private String content;
        private String author;

        public ForumResponseDto(Forum entity) {
            this.id = entity.getId();
            this.title = entity.getTitle();
            this.content = entity.getContent();
            this.author = entity.getAuthor();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class ForumUpdateRequestDto {
        private String title;
        private String content;

        @Builder
        public ForumUpdateRequestDto(String title, String content) {
            this.title = title;
            this.content = content;
        }
    }

    @Getter
    public static class ForumViewResponseDto {
        private Long id;
        private String title;
        private String author;
        private String content;
        private String modifiedDate;
        private Integer views;
        private Long userId;



        public ForumViewResponseDto(Forum entity) {
            this.id = entity.getId();
            this.title = entity.getTitle();
            this.content = entity.getContent();
            this.author = entity.getAuthor();
            this.views = entity.getViews();
            this.modifiedDate = entity.getModifiedDate();
            this.userId = entity.getUserId();
        }
    }
}
