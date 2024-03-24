package com.myinvestment.controller;

import com.myinvestment.dto.LoginDto;
import com.myinvestment.dto.LoginResponseDto;
import com.myinvestment.dto.MemberDto;
import com.myinvestment.dto.SignupResponseDto;
import com.myinvestment.service.LoginService;
import com.myinvestment.utils.ResponseDto;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class LoginController {

    private final LoginService loginService;



    @PostMapping("/signup")
    public void signup(@RequestBody MemberDto memberDto) {
        loginService.signup(memberDto);
    }

    @PostMapping("/login")
    public ResponseDto<LoginResponseDto> Login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        return loginService.login(loginDto, response);
    }
}
