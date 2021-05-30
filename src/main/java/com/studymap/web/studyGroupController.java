package com.studymap.web;


import com.studymap.config.auth.LoginUser;
import com.studymap.config.auth.dto.SessionUser;
import com.studymap.service.studyGroup.StudyGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@RequiredArgsConstructor
@Controller
public class studyGroupController {
    private final StudyGroupService studyGroupService;

    @GetMapping("/studyGroup")
    public String index(Model model, @LoginUser SessionUser user) {
        //httpSession.getAttribute("user")에서 기존에 가져오던 세션 정보값을 @LoginUeser만 사용하면 세션 정보를 가져올수 있도록 변경
        model.addAttribute("studyGroup", studyGroupService.findAllDesc());

        /* SessionUser user = (SessionUser) httpSession.getAttribute("user");*/

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "studyGroup";
    }

    @GetMapping("/studyGroup/save")
    public String studyGroupSave() { return "studyGroup-save";}
}
