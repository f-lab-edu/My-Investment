package com.myinvestment.dao;

import com.myinvestment.mapper.MemberMapper;
import lombok.Builder;
import lombok.Data;


@Builder
public class MemberDao {

//    DAO -> DB의 데이터에 접근하기 위한 객체
//
//    회원가입DAO 예시
//    이건 DB에 접근해서 회원가입때 필요한 기능 처리 메서드 들어있다.
//-> 회원 입력(insertmemher), 회원 조회(readmember)등
//
//
//
//
//    DTO -> DTO는 로직을 가지지 않는 데이터 객체 그 자체( 객체 틀정도)

    MemberMapper mapper;

    public Member insertMember(Member member){
        return mapper.insertMember(member);
    }


}
