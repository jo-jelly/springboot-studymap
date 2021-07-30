package com.studymap.web;


import com.studymap.service.forum.ForumService;
import com.studymap.service.studyGroup.StudyGroupService;
import com.studymap.web.dto.ForumDto;
import com.studymap.web.dto.StudyGroupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ForumApiController {
    private final ForumService forumService;

    @PostMapping("/api/v1/forum")
    public Long save(@RequestBody ForumDto.ForumSaveRequestDto requestDto) {

        return forumService.save(requestDto);
    }

    @PutMapping("/api/v1/forum/{id}")
    public Long update(@PathVariable Long id, @RequestBody ForumDto.ForumUpdateRequestDto requestDto){
        return forumService.update(id, requestDto);
    }

    @GetMapping("/api/v1/forum/{id}")
    public ForumDto.ForumResponseDto findById (@PathVariable Long id){
        return forumService.findById(id);
    }

   @DeleteMapping("/api/v1/forum/{id}")
    public Long delete(@PathVariable Long id) {
       forumService.delete(id);
        return id;
    }

}
