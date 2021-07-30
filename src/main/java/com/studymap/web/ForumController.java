package com.studymap.web;


import com.studymap.config.auth.LoginUser;
import com.studymap.config.auth.dto.SessionUser;
import com.studymap.service.comment.ScommentService;
import com.studymap.service.forum.ForumService;
import com.studymap.service.studyGroup.StudyGroupService;
import com.studymap.web.dto.ForumDto;
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
public class ForumController {

    private final ForumService forumService;
    private final ScommentService sCommentService;


// @PageableDefault 어노테이션을 쓰면 정렬은 물론 페이징 처리, 페이지 사이즈까지 한 줄로 구현 가능
    @GetMapping("/forum")
    public String index(Model model, @LoginUser SessionUser user, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC)Pageable pageable) {
        //httpSession.getAttribute("user")에서 기존에 가져오던 세션 정보값을 @LoginUeser만 사용하면 세션 정보를 가져올수 있도록 변경
        model.addAttribute("forumList", forumService.getForumList(pageable));
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber()); //이전 페이지
        model.addAttribute("next", pageable.next().getPageNumber());                //이후 페이지
        model.addAttribute("check", forumService.getListCheck(pageable));      //다음 페이지 있나 확인

        /* SessionUser user = (SessionUser) httpSession.getAttribute("user");*/

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "forum";
    }

    @GetMapping("/forum/save")
    public String studyGroupSave(Model model, @LoginUser SessionUser user) {
        model.addAttribute("userId", user.getId());
        model.addAttribute("userName", user.getName());

        return "forum-save";}

    @GetMapping("/forum/update/{id}")
    public String studyGroupUpdate(@PathVariable Long id, Model model) {
        ForumDto.ForumResponseDto dto = forumService.findById(id);
        model.addAttribute("forum", dto);

        return "forum-update";
    }

    @GetMapping("/forum/view/{id}")

    public String studyGroupView(@PathVariable Long id, Model model, @LoginUser SessionUser user,
                                 @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC)Pageable pageable) {
        ForumDto.ForumViewResponseDto dto = forumService.findByIdView(id);
        model.addAttribute("forum", dto);
        System.out.println("thisis dto :"+ dto);

//        //여기부터 댓글을 위해 추가
//        model.addAttribute("userId", user.getId());
//        model.addAttribute("writer", user.getName());
//        model.addAttribute("studyGroupId", id);
//        model.addAttribute("scomment", sCommentService.getViewListComment(id));
//        System.out.println("thisis coco :"+ sCommentService.getViewListComment(id));

        return "forum-view";
    }
}
