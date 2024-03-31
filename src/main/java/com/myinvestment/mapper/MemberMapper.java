package com.myinvestment.mapper;

import com.myinvestment.dao.Member;
import com.myinvestment.dao.MemberDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    Optional<Member> getMember(String email);
    String insertMember(MemberDao memberDao);

    int idCheck(String id);


}
