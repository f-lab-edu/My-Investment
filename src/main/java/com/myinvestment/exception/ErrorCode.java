package com.myinvestment.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_DUPLICATION_409(HttpStatus.CONFLICT, "이미 가입된 회원입니다."),
    LOGIN_NOT_FOUND_404(HttpStatus.NOT_FOUND, "아이디 또는 비밀번호를 잘못 입력했습니다."),
    ACCOUNT_NOT_FOUND_404(HttpStatus.NOT_FOUND, "존재하지 않는 계정입니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
