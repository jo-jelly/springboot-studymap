package com.studymap.domain.s_comment;

import com.studymap.domain.studyGroup.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SCommentRepository extends JpaRepository<SComment, Long> {

    @Query("SELECT p FROM SComment p ORDER BY p.id DESC")
    List<SComment> findAllDesc();
}
