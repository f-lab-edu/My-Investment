package com.myinvestment.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {
    private String status;
    private T data;

    public static <T> ResponseDto<T> status(T data) {
        return new ResponseDto<>("success", data);
    }
}
