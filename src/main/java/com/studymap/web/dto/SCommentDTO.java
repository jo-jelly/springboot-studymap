package com.studymap.web.dto;

import com.studymap.domain.s_comment.SComment;
import com.studymap.domain.studyGroup.StudyGroup;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SCommentDTO {

    @Getter
    @NoArgsConstructor
    public static class SCommentSaveRequestDto {
        private String content;
        private StudyGroup studyGroup;

        @Builder
        public SCommentSaveRequestDto(String content, StudyGroup studyGroup){
            this.content = content;
            this.studyGroup = studyGroup;
        }

       public SComment toEntity(){
            return SComment.builder()
                    .content(content)
                    .studyGroup(studyGroup)
                    .build();
       }

    }

    @Getter
    public static class SCommentListResponseDto {
        private Long id;
        private String content;
        private StudyGroup studyGroup;

        public SCommentListResponseDto(SComment entitny){
            this.id = entitny.getId();
            this.content = entitny.getContent();
            this.studyGroup = entitny.getStudyGroup();
        }
    }


}
