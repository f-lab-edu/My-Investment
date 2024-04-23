package com.myinvestment.exception;


import com.myinvestment.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RequestException.class)
	public ResponseDto<Object> exceptionHandler(RequestException e) {

		return ResponseDto.fail(
				e.getHttpStatus(),
				e.getMessage()
		);
	}
}
