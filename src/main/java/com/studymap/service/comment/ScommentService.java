package com.studymap.service.comment;

import com.studymap.domain.s_comment.ScommentRepository;
import com.studymap.web.dto.ScommentDTO;
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
    public List<ScommentDTO.ScommentListResponseDto> findAllDesc() {
        return sCommentRepository.findAllDesc().stream().map(ScommentDTO.ScommentListResponseDto::new).collect(Collectors.toList());

    }

    @Transactional
    public Long save(ScommentDTO.ScommentSaveRequestDto requestDto) {

        return sCommentRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public List<ScommentDTO.ScommentListResponseDto> getViewListComment(Long id){
        return sCommentRepository.findComment(id).stream().map(ScommentDTO.ScommentListResponseDto::new).collect(Collectors.toList());
    }

}
