package com.studymap.domain.studyGroup;

import com.studymap.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //클래스 내 모든 필드의 Getter 메소드를 자동으로 생성해준다.
@NoArgsConstructor //기본생성자 자동으로 추가
@Entity //테이블과 링크될 클래스임을 나타낸다.(주요 어노테이션을 클래스 가까이에 두는 습관을 가지기!)
public class StudyGroup extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long userId;
    //@colume = 선언하지 않아도 이 클래스는 모두 컬럼이 되지만 변경하고자하는 옵션이 있을경우 사용한다.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    private String area;

    private Integer views;

    private Integer member;

    private String state;

    @Builder
    public StudyGroup(String title, String content, String author,String area, int views, int member, String state, long userId)  {
        this.title = title;
        this.content = content;
        this.author = author;
        this.area = area;
        this.views = views;
        this.member = member;
        this.state = state;
        this.userId = userId;

    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;

    }
}
