package com.studymap.web;

import com.studymap.config.auth.LoginUser;
import com.studymap.config.auth.dto.SessionUser;
import com.studymap.service.forum.ForumService;
import com.studymap.service.project.ProjectService;
import com.studymap.service.studyGroup.StudyGroupService;
import com.studymap.web.dto.ProjectResponseDto;
import com.studymap.web.dto.ProjectViewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ProjectService projectService;
    private final StudyGroupService studyGroupService;
    private final ForumService forumService;
  /*  private final HttpSession httpSession;*/

    @GetMapping("/")
    public String index(Model model , @LoginUser SessionUser user, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        //httpSession.getAttribute("user")에서 기존에 가져오던 세션 정보값을 @LoginUeser만 사용하면 세션 정보를 가져올수 있도록 변경
        model.addAttribute("project", projectService.getProjectList(pageable));
        model.addAttribute("studyGroup", studyGroupService.getStudyGroupList(pageable));
        model.addAttribute("forum", forumService.getForumList(pageable));

       /* SessionUser user = (SessionUser) httpSession.getAttribute("user");*/

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }


    }