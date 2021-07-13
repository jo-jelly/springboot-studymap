package com.studymap.config.auth;

import com.studymap.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile","/studyGroup").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
        /*
             authorizeRequests() 는 URL별 권한 관리를 시작하는 옵션의 시작점으로 이게 먼저 선언되어야 antMatchers() 선언이 가능하다.
             antMatchers()는 권한 관리 대상을 지정하는 옵션으로 URL, HTTP메소드 별로 관리가 가능하다.
             .primitAll()은  antMatchers()안에 있는지정된 URL을 로그인 없이 열람이 가능하도록 했다.
             이후      .anyRequest().authenticated()는 이외에 URL에 로그인 제한을 걸어두었다.
        */
    }
}
