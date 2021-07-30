package com.studymap.domain.project;
//
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
////
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class ProjectRepositoryTest {
//
//
//    @Autowired
//    ProjectRepository projectRepository;
//
//    @AfterEach //단위 테스트가 끝날때 수행되는 메소드를 지정한다. 아래는 현재 청소개념
//    public void cleanup(){
//        projectRepository.deleteAll();
//    }
//
//    @Test
//    public void 게시글저장_불러오기(){
//        //given
//        String title = "테스트 게시글";
//        String content = "테스트 본문";
//
//        projectRepository.save(Project.builder()
//                .title(title)
//                .content(content)
//                .author("dear.jojelly@gmail.com")
//                .build());
//
//        //when
//        List<Project> projectList = projectRepository.findAll();
//
//        //then
//        Project project = projectList.get(0);
//        assertThat(project.getTitle()).isEqualTo(title);
//        assertThat(project.getContent()).isEqualTo(content);
//
//    }
//
//    @Test
//    public void BaseEntity_등록() {
//
//        //given
//        LocalDateTime now = LocalDateTime.of(2020,5,4,0,0,0);
//        projectRepository.save(Project.builder()
//        .title("title")
//        .content("content")
//        .author("author")
//        .build());
//
//        //when
//        List<Project> projectList = projectRepository.findAll();
//
//        //then
//        Project project = projectList.get(0);
//
//        System.out.println(">>>>>>>>>>>>>>>>>>> createDate = " + project.getCreatedDate()+ "," +
//                "modifiedDate=" + project.getModifiedDate());
//
//        assertThat(project.getCreatedDate()).isAfter(now);
//        assertThat(project.getModifiedDate()).toString();
//        //LocalDateTime을 String으로 바꾸면서 수정해버림..
//    }
//
//}
