package com.studymap.web;

import com.studymap.service.comment.SCommentService;
import com.studymap.web.dto.SCommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SCommentApiController {

    private final SCommentService sCommentService;

    @PostMapping("/api/v1/comment")
    public Long save(@RequestBody SCommentDTO.SCommentSaveRequestDto requestDto) {
        return sCommentService.save(requestDto);
    }
}
