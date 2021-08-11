package com.studymap.web.dto;

import com.studymap.domain.p_comment.Pcomment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PcommentDTO {

    @Getter
    @NoArgsConstructor
    public static class PcommentSaveRequestDto {
        private String content;
        private Integer projectId;
        private Integer userId;
        private String writer;

        @Builder
        public PcommentSaveRequestDto(String content, Integer projectId, Integer userId, String writer){
            this.content = content;
            this.projectId = projectId;
            this.userId = userId;
            this.writer = writer;
        }

        public Pcomment toEntity(){
            return Pcomment.builder()
                    .content(content)
                    .projectId(projectId)
                    .userId(userId)
                    .writer(writer)
                    .build();
        }

    }

    @Getter
    public static class PcommentListResponseDto {
        private Long id;
        private String content;
        private Integer projectId;
        private Integer userId;
        private String writer;
        private String modifiedDate;

        public PcommentListResponseDto(Pcomment entitny){
            this.id = entitny.getId();
            this.content = entitny.getContent();
            this.projectId = entitny.getProjectId();
            this.userId = entitny.getUserId();
            this.writer = entitny.getWriter();
            this.modifiedDate = entitny.getModifiedDate();
        }
    }



}
