package com.studymap.service.comment;

import com.studymap.domain.f_comment.FcommentRepository;
import com.studymap.domain.s_comment.ScommentRepository;
import com.studymap.web.dto.FcommentDTO;
import com.studymap.web.dto.ScommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class FcommentService {

    private  final FcommentRepository fCommentRepository;

    @Transactional(readOnly = true)
    public List<FcommentDTO.FcommentListResponseDto> findAllDesc() {
        return fCommentRepository.findAllDesc().stream().map(FcommentDTO.FcommentListResponseDto::new).collect(Collectors.toList());

    }

    @Transactional
    public Long save(FcommentDTO.FcommentSaveRequestDto requestDto) {

        return fCommentRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public List<FcommentDTO.FcommentListResponseDto> getViewListComment(Long id){
        return fCommentRepository.findComment(id).stream().map(FcommentDTO.FcommentListResponseDto::new).collect(Collectors.toList());
    }

}
