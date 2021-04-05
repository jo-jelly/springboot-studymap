package com.studymap.config.auth;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Target은 LogoinUser어노테이션이 생성될 수 있는 위치를 지정해준다.
@Target(ElementType.PARAMETER)//PARAMETER로 설치되어있는경우 메소드의 파라미터로 선언된 객체에서만 사용할수 있게된다.
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
