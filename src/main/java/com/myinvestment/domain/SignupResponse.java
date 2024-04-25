package com.myinvestment.domain;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignupResponse {

    private String email;


    public SignupResponse(String email) {
        this.email = email;
    }
}
