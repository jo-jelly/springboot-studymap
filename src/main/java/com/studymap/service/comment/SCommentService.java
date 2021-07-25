package com.studymap.service.comment;

import com.studymap.domain.s_comment.SComment;
import com.studymap.domain.s_comment.SCommentRepository;
import com.studymap.domain.studyGroup.StudyGroup;
import com.studymap.web.dto.SCommentDTO;
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
public class SCommentService {

    private  final SCommentRepository sCommentRepository;

    @Transactional(readOnly = true)
    public List<SCommentDTO.SCommentListResponseDto> findAllDesc() {
        return sCommentRepository.findAllDesc().stream().map(SCommentDTO.SCommentListResponseDto::new).collect(Collectors.toList());

    }

    @Transactional
    public Long save(SCommentDTO.SCommentSaveRequestDto requestDto) {

        return sCommentRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public List<SCommentDTO.SCommentListResponseDto> getViewListComment(Long id){
        return sCommentRepository.findComment(id).stream().map(SCommentDTO.SCommentListResponseDto::new).collect(Collectors.toList());
    }

}
