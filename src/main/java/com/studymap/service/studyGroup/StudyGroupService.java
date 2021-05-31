package com.studymap.service.studyGroup;


import com.studymap.domain.posts.Posts;
import com.studymap.domain.studyGroup.StudyGroup;
import com.studymap.domain.studyGroup.StudyGroupRepository;

import com.studymap.web.dto.PostsResponseDto;
import com.studymap.web.dto.PostsUpdateRequestDto;
import com.studymap.web.dto.StudyGroupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class StudyGroupService {

    private  final StudyGroupRepository studyGroupRepository;

    @Transactional
    public Long save(StudyGroupDto.StudyGroupSaveRequestDto requestDto) {
        return studyGroupRepository.save(requestDto.toEntity()).getId();

    }


    @Transactional
    public Long update(Long id, StudyGroupDto.StudyGroupUpdateRequestDto requestDto) {
        StudyGroup studyGroup = studyGroupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        studyGroup.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }


    @Transactional(readOnly = true)
    public StudyGroupDto.StudyGroupResponseDto findById(Long id) {
        StudyGroup entity = studyGroupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new StudyGroupDto.StudyGroupResponseDto(entity);
    }

    @Transactional(readOnly = true)//트랜젝션 범위는 유지하되 조회기능만 남겨 속도개선
    public List<StudyGroupDto.StudyGroupListResponseDto> findAllDesc() {
        return studyGroupRepository.findAllDesc().stream().map(StudyGroupDto.StudyGroupListResponseDto::new).collect(Collectors.toList());
    }




}
