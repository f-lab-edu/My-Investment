package com.myinvestment.dto.response;


import lombok.Builder;
import lombok.Getter;

@Getter
public class SignupResponseDto {

    private String email;

    public SignupResponseDto(String email) {
        this.email = email;
    }
}
