package com.studymap.web;

import com.studymap.service.project.ProjectService;
import com.studymap.web.dto.ProjectResponseDto;
import com.studymap.web.dto.ProjectSaveRequestDto;
import com.studymap.web.dto.ProjectUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProjectApiController {
    private final ProjectService projectService;

    @PostMapping("/api/v1/project")
    public Long save(@RequestBody ProjectSaveRequestDto requestDto) {

        return projectService.save(requestDto);
    }

    @PutMapping("/api/v1/project/{id}")
    public Long update(@PathVariable Long id, @RequestBody ProjectUpdateRequestDto requestDto){
        return projectService.update(id, requestDto);
    }

    @GetMapping("/api/v1/project/{id}")
    public ProjectResponseDto findById (@PathVariable Long id){
        return projectService.findById(id);
    }

    @DeleteMapping("/api/v1/project/{id}")
    public Long delete(@PathVariable Long id) {
        projectService.delete(id);
        return id;
    }

}
