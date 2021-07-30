package com.studymap.domain.forum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ForumRepository extends JpaRepository<Forum, Long> {

    @Query("SELECT p FROM Forum p ORDER BY p.id DESC")
    List<Forum> findAllDesc();

    //update문에는  @Modifying 와 @Transactional 가 들어가며 integer형태로 받기위해 인티저를 사용
    @Modifying
    @Transactional
    @Query("UPDATE Forum SET views = views + 1 WHERE id = ?1 ")
     Integer findByIdView(long id);
}