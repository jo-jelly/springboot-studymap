package com.studymap.web;

import com.studymap.service.comment.ScommentService;
import com.studymap.web.dto.SCommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ScommentApiController {

    private final ScommentService sCommentService;

    @PostMapping("/api/v1/comment")
    public Long save(@RequestBody SCommentDTO.SCommentSaveRequestDto requestDto) {
        System.out.println("requserDTOisss:"+requestDto);
        System.out.println("requserDTOcontent:"+requestDto.getContent());

        return sCommentService.save(requestDto);
    }
}
