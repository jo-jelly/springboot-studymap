package com.studymap.service.studyGroup;


import com.studymap.domain.studyGroup.StudyGroup;
import com.studymap.domain.studyGroup.StudyGroupRepository;

import com.studymap.web.dto.StudyGroupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class StudyGroupService {

    private  final StudyGroupRepository studyGroupRepository;


    //저장
    @Transactional
    public Long save(StudyGroupDto.StudyGroupSaveRequestDto requestDto) {
        return studyGroupRepository.save(requestDto.toEntity()).getId();

    }

    //업데이트
    @Transactional
    public Long update(Long id, StudyGroupDto.StudyGroupUpdateRequestDto requestDto) {
        StudyGroup studyGroup = studyGroupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.aa id=" + id));

        studyGroup.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    // 하나의 아이디를 찾아야할때
    @Transactional(readOnly = true)
    public StudyGroupDto.StudyGroupResponseDto findById(Long id) {
        StudyGroup entity = studyGroupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.bb id=" + id));

        return new StudyGroupDto.StudyGroupResponseDto(entity);
    }

    //리스트
    @Transactional(readOnly = true)//트랜젝션 범위는 유지하되 조회기능만 남겨 속도개선
    public List<StudyGroupDto.StudyGroupListResponseDto> findAllDesc() {
        return studyGroupRepository.findAllDesc().stream().map(StudyGroupDto.StudyGroupListResponseDto::new).collect(Collectors.toList());
    }

    //삭제
    @Transactional
    public void delete (Long id) {
        StudyGroup studyGroup = studyGroupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.cc id=" + id));

        studyGroupRepository.delete(studyGroup);
    }
    //상세 글
    @Transactional(readOnly = true)
    public StudyGroupDto.StudyGroupViewResponseDto findByIdView(Long id) {
        StudyGroup entity = studyGroupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.dd id=" + id));
        //Integer형태로 받는다 조회수
        Integer views = studyGroupRepository.findByIdView(id);
        System.out.println("이거예요"+views);
        return new StudyGroupDto.StudyGroupViewResponseDto(entity);
    }

    //페이징
    @Transactional
    public Page<StudyGroup> getStudyGroupList(Pageable pageable) {
        return studyGroupRepository.findAll(pageable);
    }

    //페이징 넥스트 버튼 비활성화
    @Transactional
    public Boolean getListCheck(Pageable pageable) {
        Page<StudyGroup> saved = getStudyGroupList(pageable);
        Boolean check = saved.hasNext();

        return check;
    }


}
