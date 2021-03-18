package com.studymap.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import  static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)// spring boot (스프링실행자) 실행
@WebMvcTest(controllers = HelloController.class) //web에 집중할 수 있는 어노테이션.
public class HelloControllerTest {

    @Autowired //스프링이 관리하는 bean을 주입받는다.
    private MockMvc mvc; //웹 api를 테스트 할떄 사용 spring MVC의 시작점이다.

    @Test
    public void hello가_리턴() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) //MockMvc를 통해 /hello 주소로 HTTP Get요정
                .andExpect(status().isOk()) //mvc.perform의 결과 검증 200, 404, 500와 같은 걸 검증
                .andExpect(content().string(hello)); //mvc.perform결과 검증, 응답본문 내용검증 , 여기선 "hello"가 리턴되는지
    }

    @Test
    public void helloDto가_리턴된다() throws  Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name" , name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
