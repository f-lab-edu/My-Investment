package com.myinvestment.exception;


import com.myinvestment.dto.ResponseDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RequestException.class)
    public ResponseDto exceptionHandler(RequestException e) {

        return ResponseDto.fail(
                e.getHttpStatus(),
                e.getMessage()
        );
    }
}
