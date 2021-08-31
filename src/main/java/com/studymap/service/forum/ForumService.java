package com.studymap.service.forum;


import com.studymap.domain.forum.Forum;
import com.studymap.domain.forum.ForumRepository;
import com.studymap.domain.project.Project;
import com.studymap.web.dto.ForumDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ForumService {

    private  final ForumRepository forumRepository;


    //저장
    @Transactional
    public Long save(ForumDto.ForumSaveRequestDto requestDto) {
        return forumRepository.save(requestDto.toEntity()).getId();

    }

    //업데이트
    @Transactional
    public Long update(Long id, ForumDto.ForumUpdateRequestDto requestDto) {
        Forum forum = forumRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.aa id=" + id));

        forum.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    // 하나의 아이디를 찾아야할때
    @Transactional(readOnly = true)
    public ForumDto.ForumResponseDto findById(Long id) {
        Forum entity = forumRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.bb id=" + id));

        return new ForumDto.ForumResponseDto(entity);
    }

    //리스트
    @Transactional(readOnly = true)//트랜젝션 범위는 유지하되 조회기능만 남겨 속도개선
    public List<ForumDto.ForumListResponseDto> findAllDesc() {
        return forumRepository.findAllDesc().stream().map(ForumDto.ForumListResponseDto::new).collect(Collectors.toList());
    }

    //삭제
    @Transactional
    public void delete (Long id) {
        Forum forum = forumRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.cc id=" + id));

        forumRepository.delete(forum);
    }
    //상세 글
    @Transactional(readOnly = true)
    public ForumDto.ForumViewResponseDto findByIdView(Long id) {
        Forum entity = forumRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.dd id=" + id));
        //Integer형태로 받는다 조회수
        Integer views = forumRepository.findByIdView(id);
        System.out.println("이거예요"+views);
        return new ForumDto.ForumViewResponseDto(entity);
    }


    //페이징
    @Transactional
    public Page<Forum> getForumList(Pageable pageable) {
        return forumRepository.findAll(pageable);
    }

    //페이징 넥스트 버튼 비활성화
    @Transactional
    public Boolean getListCheck(Pageable pageable) {
        Page<Forum> saved = getForumList(pageable);
        Boolean check = saved.hasNext();

        return check;
    }

    //검색
    @Transactional
    public Page<Forum> searchForums(String keyword, Pageable pageable) {
        Page<Forum> forumListResponseDtoList = forumRepository.findByTitleContaining(keyword, pageable);
        return forumListResponseDtoList;
    }
}
