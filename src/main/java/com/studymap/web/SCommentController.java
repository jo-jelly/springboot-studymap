package com.studymap.web;

import com.studymap.config.auth.LoginUser;
import com.studymap.config.auth.dto.SessionUser;
import com.studymap.domain.s_comment.SComment;
import com.studymap.service.comment.SCommentService;
import com.studymap.web.dto.SCommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class SCommentController {
    private final SCommentService sCommentService;

    @GetMapping("/scomment/{id}")
    public String index(Model model, @LoginUser SessionUser user, @PathVariable Long id) {
        model.addAttribute("userId", user.getId());
        model.addAttribute("userName", user.getName());
        model.addAttribute("sgId", id);
        model.addAttribute("scomment", sCommentService.findAllDesc());

        return "scomment";
    }


}
