package com.myinvestment.dao;

import com.myinvestment.mapper.MemberMapper;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class MemberDao {

    private Long id;
    private String email;
    private String nickname;
    private String password;


//    MemberMapper mapper;

//    public Member insertMember(Member member){
//        return mapper.insertMember(MemberDao);
//    }

}
