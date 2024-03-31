package com.myinvestment.controller;

import com.myinvestment.dto.request.MemberRequestDto;
import com.myinvestment.service.LoginService;
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
    public ResponseEntity<Void> signup(@RequestBody @Valid MemberRequestDto memberRequestDto) {
        loginService.signup(memberRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

//    @PostMapping("/login")
//    public ResponseDto<LoginResponseDto> Login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
//        return loginService.login(loginDto, response);
//    }
}
