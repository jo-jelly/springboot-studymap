package com.studymap.web;

import com.studymap.config.auth.LoginUser;
import com.studymap.config.auth.dto.SessionUser;
import com.studymap.service.posts.PostsService;
import com.studymap.service.studyGroup.StudyGroupService;
import com.studymap.web.dto.PostsListResponseDto;
import com.studymap.web.dto.PostsResponseDto;
import com.studymap.web.dto.PostsViewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final StudyGroupService studyGroupService;
  /*  private final HttpSession httpSession;*/

    @GetMapping("/")
    public String index(Model model , @LoginUser SessionUser user) {
        //httpSession.getAttribute("user")에서 기존에 가져오던 세션 정보값을 @LoginUeser만 사용하면 세션 정보를 가져올수 있도록 변경
        model.addAttribute("posts", postsService.findAllDesc());
        model.addAttribute("studyGroup", studyGroupService.findAllDesc());

       /* SessionUser user = (SessionUser) httpSession.getAttribute("user");*/

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

    @GetMapping("/posts/view/{id}")
    public String postsview(@PathVariable Long id, Model model) {
        PostsViewResponseDto dto = postsService.findByIdView(id);
        model.addAttribute("postsView", dto);

        return "posts-view";
    }

    }