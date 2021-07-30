package com.studymap.service.project;


import com.studymap.domain.project.Project;
import com.studymap.domain.project.ProjectRepository;
import com.studymap.domain.studyGroup.StudyGroup;
import com.studymap.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional
    public Long save(ProjectSaveRequestDto requestDto) {

        return projectRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ProjectUpdateRequestDto requestDto) {
        // 영속성 컨텍스트에 데이터가 있는지 조회
        Project posts = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.gg id=" + id));
         /*
          Spring Data Jpa를 쓴다면 기본 옵션으로 EntityManager가 활성화되어 영속성 컨텍스트가 유지된 상태다. (영속성 컨텍스트에 엔티티 객체가 들어있는 상태)
          업데이트로 값만 바꿔주면 트랜잭션 끝나는 시점에 DB반영
          따라서 업데이트 쿼리 날리는 부분이 없다.
        */
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    //하나의 아이디를 찾아야할때
    @Transactional(readOnly = true)
    public ProjectResponseDto findById(Long id) {
        Project entity = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new ProjectResponseDto(entity);
    }

    //리스트
    @Transactional(readOnly = true) //readOnly = true는 트랜젝션 범위는 유지하되 조회기능만 남겨 조회속도가 개선된다.
    public List<ProjectListResponseDto> findAllDesc() {
        return projectRepository.findAllDesc().stream().map(ProjectListResponseDto::new).collect(Collectors.toList());
    }


    @Transactional
    public void delete (Long id) {
        Project posts = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        projectRepository.delete(posts);
    }
    //상세 글 페이지
    @Transactional(readOnly = true)
    public ProjectViewResponseDto findByIdView(Long id) {
        Project entity = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        //Integer형태로 받는다 조회수
        Integer views = projectRepository.findByIdView(id);
        System.out.println("이거"+views);
        return new ProjectViewResponseDto(entity);
    }


    //페이징
    @Transactional
    public Page<Project> getProjectList(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    //페이징 넥스트 버튼 비활성화
    @Transactional
    public Boolean getListCheck(Pageable pageable) {
        Page<Project> saved = getProjectList(pageable);
        Boolean check = saved.hasNext();

        return check;
    }
}
