package com.studymap.domain.s_comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScommentRepository extends JpaRepository<Scomment, Long> {

    @Query("SELECT p FROM Scomment p ORDER BY p.id DESC")
    List<Scomment> findAllDesc();

    //쿼리를 사용해 네이티브 쿼리를 수행하려면 , nativeQuery = true를 추가해주어야 한다.
    //native 쿼리를 사용해서인지 p를 인식 못해서 select * from 처럼 일반쿼리 처리함.
    //JPA생성시 컬럼명이 studyGroupId인데 이를 스네이크방식으로 인식하여 study_group_id로 처리함
    @Query(value = "SELECT * FROM Scomment WHERE study_group_id =?1 ORDER By id DESC", nativeQuery = true)
    List<Scomment> findComment(long id);
}
