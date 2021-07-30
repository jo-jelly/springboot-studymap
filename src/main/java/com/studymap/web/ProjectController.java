package com.studymap.web;


import com.studymap.config.auth.LoginUser;
import com.studymap.config.auth.dto.SessionUser;
import com.studymap.service.comment.PcommentService;
import com.studymap.service.project.ProjectService;
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
public class ProjectController {

    private final ProjectService projectService;
    private final PcommentService pCommentService;


// @PageableDefault 어노테이션을 쓰면 정렬은 물론 페이징 처리, 페이지 사이즈까지 한 줄로 구현 가능
    @GetMapping("/project")
    public String index(Model model, @LoginUser SessionUser user, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC)Pageable pageable) {
        //httpSession.getAttribute("user")에서 기존에 가져오던 세션 정보값을 @LoginUeser만 사용하면 세션 정보를 가져올수 있도록 변경
        model.addAttribute("projectList", projectService.getProjectList(pageable));
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber()); //이전 페이지
        model.addAttribute("next", pageable.next().getPageNumber());                //이후 페이지
        model.addAttribute("check", projectService.getListCheck(pageable));      //다음 페이지 있나 확인

        /* SessionUser user = (SessionUser) httpSession.getAttribute("user");*/

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "project";
    }

    @GetMapping("/project/save")
    public String studyGroupSave(Model model, @LoginUser SessionUser user) {
        model.addAttribute("userId", user.getId());
        model.addAttribute("userName", user.getName());

        return "project-save";}

    @GetMapping("/project/update/{id}")
    public String studyGroupUpdate(@PathVariable Long id, Model model) {
        ProjectResponseDto dto = projectService.findById(id);
        model.addAttribute("project", dto);

        return "project-update";
    }

    @GetMapping("/project/view/{id}")

    public String projectView(@PathVariable Long id, Model model, @LoginUser SessionUser user,
                                 @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC)Pageable pageable) {
        ProjectViewResponseDto dto = projectService.findByIdView(id);
        model.addAttribute("projectView", dto);
        System.out.println("thisis dto :"+ dto);

        //여기부터 댓글을 위해 추가
        model.addAttribute("userId", user.getId());
        model.addAttribute("writer", user.getName());
        model.addAttribute("projectId", id);
        model.addAttribute("pcomment", pCommentService.getViewListComment(id));
        System.out.println("thisis coco :"+ pCommentService.getViewListComment(id));

        return "project-view";
    }
}
