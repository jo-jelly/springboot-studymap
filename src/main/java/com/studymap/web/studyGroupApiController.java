package com.studymap.web;


import com.studymap.service.studyGroup.StudyGroupService;
import com.studymap.web.dto.StudyGroupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class studyGroupApiController {
    private final StudyGroupService studyGroupService;

    @PostMapping("/api/v1/studyGroup")
    public Long save(@RequestBody StudyGroupDto.StudyGroupSaveRequestDto requestDto) {

        return studyGroupService.save(requestDto);
    }

    @PutMapping("/api/v1/studyGroup/{id}")
    public Long update(@PathVariable Long id, @RequestBody StudyGroupDto.StudyGroupUpdateRequestDto requestDto){
        return studyGroupService.update(id, requestDto);
    }

    @GetMapping("/api/v1/studyGroup/{id}")
    public StudyGroupDto.StudyGroupResponseDto findById (@PathVariable Long id){
        return studyGroupService.findById(id);
    }

   @DeleteMapping("/api/v1/studyGroup/{id}")
    public Long delete(@PathVariable Long id) {
        studyGroupService.delete(id);
        return id;
    }

}
