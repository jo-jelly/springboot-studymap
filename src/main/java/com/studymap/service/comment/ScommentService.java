package com.studymap.service.comment;

import com.studymap.domain.s_comment.ScommentRepository;
import com.studymap.web.dto.SCommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ScommentService {

    private  final ScommentRepository sCommentRepository;

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
