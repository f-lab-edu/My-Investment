package com.myinvestment.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private boolean success;
    private String result;
    private Error error;


    public static <T> ResponseDto success(String result) {
        return new ResponseDto(true, result, null);
    }

    public static <T> ResponseDto fail(HttpStatus httpStatus, String message) {
        return new ResponseDto(false, null, new Error(httpStatus, message));
    }

    @Getter
    @AllArgsConstructor
    static class Error {
        private HttpStatus httpStatus;
        private String message;
    }


}
