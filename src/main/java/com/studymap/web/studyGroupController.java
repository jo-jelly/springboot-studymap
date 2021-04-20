package com.studymap.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@Controller
public class studyGroupController {

    @GetMapping("/studyGroup")
    public String studyGroup(){

        return "studyGroup";
    }

}
