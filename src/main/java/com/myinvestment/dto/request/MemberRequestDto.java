package com.myinvestment.dto.request;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberRequestDto {

    private String email;
    private String nickname;
    private String password;

    public void setEncodedPwd(String encodedPwd) {
        this.password = encodedPwd;
    }

}
