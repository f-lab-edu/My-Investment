package com.myinvestment.domain;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {

    private Long id;
    private String email;
    private String nickname;
    private String password;


}
