package com.studymap.domain.f_comment;

import com.studymap.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //클래스 내 모든 필드의 Getter 메소드를 자동으로 생성해준다.
@NoArgsConstructor //기본생성자 자동으로 추가
@Entity//테이블과 링크될 클래스임을 나타낸다.(주요 어노테이션을 클래스 가까이에 두는 습관을 가지기!)
public class Fcomment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String writer;

    private Integer forumId;

    private Integer userId;


    @Builder
    public Fcomment(String content, String writer, Integer forumId, Integer userId) {
        this.content = content;
        this.writer = writer;
        this.forumId = forumId;
        this.userId = userId;

    }
}
