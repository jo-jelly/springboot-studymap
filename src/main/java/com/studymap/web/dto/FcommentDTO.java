package com.studymap.web.dto;

import com.studymap.domain.f_comment.Fcomment;
import com.studymap.domain.p_comment.Pcomment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class FcommentDTO {

    @Getter
    @NoArgsConstructor
    public static class FcommentSaveRequestDto {
        private String content;
        private Integer forumId;
        private Integer userId;
        private String writer;

        @Builder
        public FcommentSaveRequestDto(String content, Integer forumId, Integer userId, String writer){
            this.content = content;
            this.forumId = forumId;
            this.userId = userId;
            this.writer = writer;
        }

        public Fcomment toEntity(){
            return Fcomment.builder()
                    .content(content)
                    .forumId(forumId)
                    .userId(userId)
                    .writer(writer)
                    .build();
        }

    }

    @Getter
    public static class FcommentListResponseDto {
        private Long id;
        private String content;
        private Integer forumId;
        private Integer userId;
        private String writer;
        private String modifiedDate;

        public FcommentListResponseDto(Fcomment entitny){
            this.id = entitny.getId();
            this.content = entitny.getContent();
            this.forumId = entitny.getForumId();
            this.userId = entitny.getUserId();
            this.writer = entitny.getWriter();
            this.modifiedDate = entitny.getModifiedDate();
        }
    }



}
