package com.studymap.domain.studyGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {

    //SpringDataJpa에서 제공하지 않는 메소드는 아래 처럼 쿼리로 작성해도 된다.
    @Query("SELECT p FROM StudyGroup p ORDER BY p.id DESC")
    List<StudyGroup> findAllDesc();
}
