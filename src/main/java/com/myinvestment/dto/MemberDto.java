package com.myinvestment.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
@Data
public class MemberDto {

    private String email;
    private String nickname;
    private String password;

    public void setEncodedPwd(String encodedPwd) {
        this.password = encodedPwd;
    }

}
