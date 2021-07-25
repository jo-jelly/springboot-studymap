package com.studymap.web;


import com.studymap.config.auth.LoginUser;
import com.studymap.config.auth.dto.SessionUser;
import com.studymap.domain.s_comment.SComment;
import com.studymap.domain.studyGroup.StudyGroup;
import com.studymap.domain.studyGroup.StudyGroupRepository;
import com.studymap.service.comment.SCommentService;
import com.studymap.service.studyGroup.StudyGroupService;
import com.studymap.web.dto.PostsResponseDto;
import com.studymap.web.dto.PostsViewResponseDto;
import com.studymap.web.dto.StudyGroupDto;
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
public class studyGroupController {

    private final StudyGroupService studyGroupService;
    private final SCommentService sCommentService;


// @PageableDefault 어노테이션을 쓰면 정렬은 물론 페이징 처리, 페이지 사이즈까지 한 줄로 구현 가능
    @GetMapping("/studyGroup")
    public String index(Model model, @LoginUser SessionUser user, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC)Pageable pageable) {
        //httpSession.getAttribute("user")에서 기존에 가져오던 세션 정보값을 @LoginUeser만 사용하면 세션 정보를 가져올수 있도록 변경
        model.addAttribute("studyGroup", studyGroupService.findAllDesc());
        model.addAttribute("studyGroupList", studyGroupService.getStudyGroupList(pageable));
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber()); //이전 페이지
        model.addAttribute("next", pageable.next().getPageNumber());                //이후 페이지
        model.addAttribute("check", studyGroupService.getListCheck(pageable));      //다음 페이지 있나 확인

        /* SessionUser user = (SessionUser) httpSession.getAttribute("user");*/

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "studyGroup";
    }

    @GetMapping("/studyGroup/save")
    public String studyGroupSave(Model model, @LoginUser SessionUser user) {
        model.addAttribute("userId", user.getId());
        model.addAttribute("userName", user.getName());

        return "studyGroup-save";}

    @GetMapping("/studyGroup/update/{id}")
    public String studyGroupUpdate(@PathVariable Long id, Model model) {
        StudyGroupDto.StudyGroupResponseDto dto = studyGroupService.findById(id);
        model.addAttribute("studyGroup", dto);

        return "studyGroup-update";
    }

    @GetMapping("/studyGroup/view/{id}")

    public String studyGroupView(@PathVariable Long id, Model model, @LoginUser SessionUser user,
                                 @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC)Pageable pageable) {
        StudyGroupDto.StudyGroupViewResponseDto dto = studyGroupService.findByIdView(id);
        model.addAttribute("studyGroupView", dto);
        System.out.println("thisis dto :"+ dto);

        //여기부터 댓글을 위해 추가
        model.addAttribute("userId", user.getId());
        model.addAttribute("writer", user.getName());
        model.addAttribute("studyGroupId", id);
        model.addAttribute("scomment", sCommentService.getViewListComment(id));
        System.out.println("thisis coco :"+ sCommentService.getViewListComment(id));

        return "studyGroup-view";
    }
}
