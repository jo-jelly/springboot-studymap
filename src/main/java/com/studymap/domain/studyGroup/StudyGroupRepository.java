package com.studymap.domain.studyGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {

    @Query("SELECT p FROM StudyGroup p ORDER BY p.id DESC")
    List<StudyGroup> findAllDesc();
}
