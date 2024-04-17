package com.myinvestment.controller;

import com.myinvestment.domain.LoginRequest;
import com.myinvestment.domain.MemberRequest;
import com.myinvestment.domain.LoginResponse;
import com.myinvestment.domain.SignupResponse;
import com.myinvestment.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/member")
public class LoginController {


    private final LoginService loginService;

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody MemberRequest memberRequest) {
        loginService.signup(memberRequest);
        SignupResponse dto = new SignupResponse(memberRequest.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest,
                                               HttpServletRequest httpServletRequest) {
        loginService.login(loginRequest);

        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("loginMember", loginRequest.getEmail());
        session.setMaxInactiveInterval(60 * 30);
        LoginResponse dto = new LoginResponse(loginRequest.getEmail());

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
