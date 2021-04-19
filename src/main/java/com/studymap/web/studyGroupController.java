package com.studymap.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class studyGroupController {

    @GetMapping("/studyGroup")//Http Method인 get의 요청을 받을 수 있는 API을 만들어준다.
    public String hello(){

        return "studyGroup";
    }

}
