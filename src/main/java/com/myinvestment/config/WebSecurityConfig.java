package com.myinvestment.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
     web.ignoring().requestMatchers
     : () 안에 해당하는 요청들을 Spring Security의 필터 체인에서 제외시켜줍니다.
     /configuration/security 는 보안 구성과 관련된 경로입니다.
     /webjars/** 는 웹 애플리케이션에서 사용되는 JS, CSS 등의 라이브러리를 포함합니다.
     */
    @Bean
    public WebSecurityCustomizer ignoringCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers(
                        "/configuration/security",
                        "/webjars/**");
    }


    /*
    * http.authorizeHttpRequests(request -> request.requestMatchers("/").permitAll())
    * 모든 요청에 대해 접근을 허용합니다.
    * */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/")
                        .permitAll()
                )
                .authorizeHttpRequests(request -> request.anyRequest().permitAll());

        return http.build();
    }
}
