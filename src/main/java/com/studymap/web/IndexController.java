package com.studymap.web;

import com.studymap.config.auth.LoginUser;
import com.studymap.config.auth.dto.SessionUser;
import com.studymap.service.project.ProjectService;
import com.studymap.service.studyGroup.StudyGroupService;
import com.studymap.web.dto.ProjectResponseDto;
import com.studymap.web.dto.ProjectViewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ProjectService projectService;
    private final StudyGroupService studyGroupService;
  /*  private final HttpSession httpSession;*/

    @GetMapping("/")
    public String index(Model model , @LoginUser SessionUser user) {
        //httpSession.getAttribute("user")에서 기존에 가져오던 세션 정보값을 @LoginUeser만 사용하면 세션 정보를 가져올수 있도록 변경
        model.addAttribute("project", projectService.findAllDesc());
        model.addAttribute("studyGroup", studyGroupService.findAllDesc());

       /* SessionUser user = (SessionUser) httpSession.getAttribute("user");*/

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/project/save")
    public String postsSave() {
        return "project-save";
    }

    @GetMapping("/project/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        ProjectResponseDto dto = projectService.findById(id);
        model.addAttribute("project", dto);

        return "project-update";
    }

    @GetMapping("/project/view/{id}")

    public String postsView(@PathVariable Long id, Model model) {
        ProjectViewResponseDto dto = projectService.findByIdView(id);
        model.addAttribute("projectView", dto);

        return "project-view";
    }

    }