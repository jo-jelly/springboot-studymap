package com.studymap.web.dto;

import com.studymap.domain.s_comment.Scomment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SCommentDTO {

    @Getter
    @NoArgsConstructor
    public static class SCommentSaveRequestDto {
        private String content;
        private Integer studyGroupId;
        private Integer userId;
        private String writer;

        @Builder
        public SCommentSaveRequestDto(String content, Integer studyGroupId, Integer userId, String writer){
            this.content = content;
            this.studyGroupId = studyGroupId;
            this.userId = userId;
            this.writer = writer;
        }

        public Scomment toEntity(){
            return Scomment.builder()
                    .content(content)
                    .studyGroupId(studyGroupId)
                    .userId(userId)
                    .writer(writer)
                    .build();
        }

    }

    @Getter
    public static class SCommentListResponseDto {
        private Long id;
        private String content;
        private Integer studyGroupId;
        private Integer userId;
        private String writer;

        public SCommentListResponseDto(Scomment entitny){
            this.id = entitny.getId();
            this.content = entitny.getContent();
            this.studyGroupId = entitny.getStudyGroupId();
            this.userId = entitny.getUserId();
            this.writer = entitny.getWriter();
        }
    }



}
