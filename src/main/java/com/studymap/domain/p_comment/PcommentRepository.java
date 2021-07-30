package com.studymap.domain.p_comment;

import com.studymap.domain.s_comment.Scomment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PcommentRepository extends JpaRepository<Pcomment, Long> {

    @Query("SELECT p FROM Pcomment p ORDER BY p.id DESC")
    List<Pcomment> findAllDesc();

    //쿼리를 사용해 네이티브 쿼리를 수행하려면 , nativeQuery = true를 추가해주어야 한다.
    //native 쿼리를 사용해서인지 p를 인식 못해서 select * from 처럼 일반쿼리 처리함.
    //JPA생성시 컬럼명이 studyGroupId인데 이를 스네이크방식으로 인식하여 study_group_id로 처리함
    @Query(value = "SELECT * FROM pcomment WHERE project_id =?1 ORDER By id DESC", nativeQuery = true)
    List<Pcomment> findComment(long id);
}
