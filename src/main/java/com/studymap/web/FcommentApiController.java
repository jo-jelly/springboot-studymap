package com.studymap.web;

import com.studymap.service.comment.FcommentService;
import com.studymap.service.comment.PcommentService;
import com.studymap.web.dto.FcommentDTO;
import com.studymap.web.dto.PcommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FcommentApiController {

    private final FcommentService fCommentService;

    @PostMapping("/api/v1/fcomment")
    public Long save(@RequestBody FcommentDTO.FcommentSaveRequestDto requestDto) {
        System.out.println("requserDTOisss:"+requestDto);
        System.out.println("requserDTOcontent:"+requestDto.getContent());

        return fCommentService.save(requestDto);
    }
}
