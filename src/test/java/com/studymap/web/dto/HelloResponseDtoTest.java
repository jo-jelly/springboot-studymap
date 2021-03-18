package com.studymap.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 룸북_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);


        // assertThat = 검증하고싶을 대상을 메소드 인자로 받는다.isEqualTo와 이어서 사용 가능하다.
        //isEqualTo = 비교 메소드로 assertThat에 있는 값과 비교해서 같을때만 성공한다.

    }
}
