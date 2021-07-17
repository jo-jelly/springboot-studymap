package com.studymap.service.studyGroup;


import com.studymap.domain.studyGroup.StudyGroup;
import com.studymap.domain.studyGroup.StudyGroupRepository;

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
    private static final int BLOCK_PAGE_NUM_COUNT = 5;// 블럭에 존재하는 페이지의 수
    private static final int PAGE_POST_COUNT = 4;// 한 페이지에 존재하는 게시글의 수



    @Transactional
    public Long save(StudyGroupDto.StudyGroupSaveRequestDto requestDto) {
        return studyGroupRepository.save(requestDto.toEntity()).getId();

    }


    @Transactional
    public Long update(Long id, StudyGroupDto.StudyGroupUpdateRequestDto requestDto) {
        StudyGroup studyGroup = studyGroupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.aa id=" + id));

        studyGroup.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }


    @Transactional(readOnly = true)
    public StudyGroupDto.StudyGroupResponseDto findById(Long id) {
        StudyGroup entity = studyGroupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.bb id=" + id));

        return new StudyGroupDto.StudyGroupResponseDto(entity);
    }

    @Transactional(readOnly = true)//트랜젝션 범위는 유지하되 조회기능만 남겨 속도개선
    public List<StudyGroupDto.StudyGroupListResponseDto> findAllDesc(Integer pageNum) {
        return studyGroupRepository.findAllDesc().stream().map(StudyGroupDto.StudyGroupListResponseDto::new).collect(Collectors.toList());
    }


    @Transactional
    public void delete (Long id) {
        StudyGroup studyGroup = studyGroupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.cc id=" + id));

        studyGroupRepository.delete(studyGroup);
    }
    //상세 글 페이지
    @Transactional(readOnly = true)
    public StudyGroupDto.StudyGroupViewResponseDto findByIdView(Long id) {
        StudyGroup entity = studyGroupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.dd id=" + id));
        //Integer형태로 받는다 조회수
        Integer views = studyGroupRepository.findByIdView(id);
        System.out.println("이거예요"+views);
        return new StudyGroupDto.StudyGroupViewResponseDto(entity);
    }




}
