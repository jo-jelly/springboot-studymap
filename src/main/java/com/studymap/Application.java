package com.studymap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication //이 위치부터 설정을 읽어가게 된다.
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        //내장 was서버 실행하게 한다.
    }
}
