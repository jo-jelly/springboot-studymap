package com.studymap.domain.studyGroup;

import com.studymap.domain.project.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {

    @Query("SELECT p FROM StudyGroup p ORDER BY p.id DESC")
    List<StudyGroup> findAllDesc();

    //update문에는  @Modifying 와 @Transactional 가 들어가며 integer형태로 받기위해 인티저를 사용

    @Modifying
    @Transactional
    @Query("UPDATE StudyGroup SET views = views + 1 WHERE id = ?1 ")
    Integer findByIdView(long id);

    Page<StudyGroup> findByTitleContaining(String title, Pageable pageable);
}
