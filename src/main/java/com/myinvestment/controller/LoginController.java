package com.myinvestment.controller;

import com.myinvestment.dto.request.LoginRequestDto;
import com.myinvestment.dto.request.MemberRequestDto;
import com.myinvestment.dto.response.LoginResponseDto;
import com.myinvestment.dto.response.SignupResponseDto;
import com.myinvestment.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class LoginController {


    private final LoginService loginService;

    @PostMapping("/v1/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
        loginService.signup(memberRequestDto);
        SignupResponseDto dto = new SignupResponseDto(memberRequestDto.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

//    @PostMapping("/v1/login")
//    public ResponseEntity<LoginResponseDto> Login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest httpServletRequest) {
//        loginService.login(loginRequestDto);
//
//        HttpSession session = httpServletRequest.getSession();
//        session.setAttribute("loginMember", loginRequestDto.getEmail());
//        session.setMaxInactiveInterval(60 * 30);
//
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
}
