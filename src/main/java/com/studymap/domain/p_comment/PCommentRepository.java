package com.studymap.domain.p_comment;

import com.studymap.domain.s_comment.SComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PCommentRepository extends JpaRepository<SComment, Long> {
}
