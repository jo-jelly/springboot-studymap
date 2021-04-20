package com.studymap.web;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class studyGroupController {

    @GetMapping("/studyGroup")
    public String hello(){

        return "studyGroup";
    }

}
