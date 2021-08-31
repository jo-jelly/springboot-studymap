package com.studymap.domain.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p ORDER BY p.id DESC")
    List<Project> findAllDesc();

    //update문에는  @Modifying 와 @Transactional 가 들어가며 integer형태로 받기위해 인티저를 사용
    @Modifying
    @Transactional
    @Query("UPDATE Project SET views = views + 1 WHERE id = ?1 ")
     Integer findByIdView(long id);

    //JpaRepository에서는 By 뒷 부분은 SQL의 where 조건 절에 해당된다. 따라서, Containing을 붙여주면 Like 검색이 된다.
    Page<Project> findByTitleContaining(String title, Pageable pageable);


//        @Query("SELECT p FROM Project p WHERE p.title LIKE %:keyword%")
//        List<Project> findTitleContaining(String keyword, Pageable pageable);
}