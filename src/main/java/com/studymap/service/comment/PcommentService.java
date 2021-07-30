package com.studymap.service.comment;

import com.studymap.domain.p_comment.PcommentRepository;
import com.studymap.web.dto.PcommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PcommentService {

    private  final PcommentRepository pCommentRepository;

    @Transactional(readOnly = true)
    public List<PcommentDTO.PcommentListResponseDto> findAllDesc() {
        return pCommentRepository.findAllDesc().stream().map(PcommentDTO.PcommentListResponseDto::new).collect(Collectors.toList());

    }

    @Transactional
    public Long save(PcommentDTO.PcommentSaveRequestDto requestDto) {

        return pCommentRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public List<PcommentDTO.PcommentListResponseDto> getViewListComment(Long id){
        return pCommentRepository.findComment(id).stream().map(PcommentDTO.PcommentListResponseDto::new).collect(Collectors.toList());
    }

}
