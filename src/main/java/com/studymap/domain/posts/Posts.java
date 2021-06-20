package com.studymap.domain.posts;


import com.studymap.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //getter메소드를 자동생성
@NoArgsConstructor //기본생성자 자동생성
@Entity //테이블에 링크될 클래스를 명
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@colume = 선언하지 않아도 이 클래스는 모두 컬럼이 되지만 변경하고자하는 옵션이 있을경우 사용한다.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    private Integer views;


    @Builder
    public Posts(String title, String content, String author, int views) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.views = views;

    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;

    }
}
