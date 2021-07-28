package com.studymap.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studymap.domain.project.Project;
import com.studymap.domain.project.ProjectRepository;
import com.studymap.web.dto.ProjectSaveRequestDto;
import com.studymap.web.dto.ProjectUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc; //MockMvc를 사용하도록해줌

    @AfterEach // junit 5
    public void tearDown() throws Exception {
        projectRepository.deleteAll();
    }

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(roles = "USER") //가짜로 인증된 사용자
    public void Posts_등록된다() throws Exception {
        //given
        String title = "title";
        String content = "content";
        ProjectSaveRequestDto requestDto = ProjectSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author("author")
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts";

        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Project> all = projectRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }

    @Test
    @WithMockUser(roles = "USER")
    public void Posts_수정되다() throws Exception{
        //given

        Project savedPosts = projectRepository.save(Project.builder()
        .title("title")
        .content("content")
        .author("author")
        .build());

        Long updataId = savedPosts.getId();
        String expectedTitle = "title2";
        String expectedContnet = "content2";

        ProjectUpdateRequestDto requestDto = ProjectUpdateRequestDto.builder()
                .title(expectedTitle)
                .content(expectedContnet)
                .build();

                String url = "http://localhost:" + port + "/api/v1/posts/" + updataId;

        HttpEntity<ProjectUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        mvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Project> all = projectRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContnet);
    }

}