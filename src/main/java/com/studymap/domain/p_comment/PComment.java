package com.studymap.domain.p_comment;

import com.studymap.domain.BaseTimeEntity;
import com.studymap.domain.studyGroup.StudyGroup;
import com.studymap.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //클래스 내 모든 필드의 Getter 메소드를 자동으로 생성해준다.
@NoArgsConstructor //기본생성자 자동으로 추가
@Entity//테이블과 링크될 클래스임을 나타낸다.(주요 어노테이션을 클래스 가까이에 두는 습관을 가지기!)
public class PComment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment;

    private String writer;

    private Integer postsId;

    private Integer userId;


    @Builder
    public PComment(String comment, String writer, Integer postsId, Integer userId) {
        this.comment = comment;
        this.writer = writer;
        this.postsId = postsId;
        this.userId = userId;

    }
}
