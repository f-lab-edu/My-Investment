package com.myinvestment.mapper;

import com.myinvestment.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    Optional<Member> getMember(String email);

    Optional<Member> memberCheck(String email);

    Optional<Member> passwordCheck(String password);

    int insertMember(Member member);


}
