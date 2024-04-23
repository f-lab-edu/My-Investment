package com.myinvestment.dto;


import ch.qos.logback.core.spi.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {

    private boolean fail;
    private String result;
    private Error error;

    public static <T> ResponseDto<T> fail(HttpStatus httpStatus, String message) {
        return new ResponseDto<>(false, null, new Error(httpStatus, message));
    }

    @Getter
    @AllArgsConstructor
    static class Error{
        private HttpStatus httpStatus;
        private String message;
    }


}
