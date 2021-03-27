package com.studymap.domain;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //Entitiy 클래스들이 이 클래스를 상속할경우 필드들도 칼럼으로 인식하게 된다.
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

        @CreatedDate //Entity 가 생성되어 저장될 때 시간이 자동 저장된다.
    private LocalDateTime createdDate;

        @LastModifiedDate //조회한Entity의 갓을 변경할때 시간이 자동으로 저장된다.
    private LocalDateTime modifiedDate;

}
