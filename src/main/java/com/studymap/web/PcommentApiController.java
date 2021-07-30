package com.studymap.web;

import com.studymap.service.comment.PcommentService;
import com.studymap.web.dto.PcommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PcommentApiController {

    private final PcommentService pCommentService;

    @PostMapping("/api/v1/pcomment")
    public Long save(@RequestBody PcommentDTO.PcommentSaveRequestDto requestDto) {
        System.out.println("requserDTOisss:"+requestDto);
        System.out.println("requserDTOcontent:"+requestDto.getContent());

        return pCommentService.save(requestDto);
    }
}
