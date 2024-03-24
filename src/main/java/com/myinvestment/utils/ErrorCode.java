package com.myinvestment.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_DUPLICATION_409(HttpStatus.CONFLICT, "이미 가입된 회원입니다."),
    LOGIN_NOT_FOUND_404(HttpStatus.NOT_FOUND, "아이디 또는 비밀번호를 잘못 입력했습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
