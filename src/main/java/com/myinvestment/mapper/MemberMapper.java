package com.myinvestment.mapper;

import com.myinvestment.dao.MemberDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    Optional<MemberDao> getMember(String email);
    Optional<MemberDao> memberCheck(String email);
    Optional<MemberDao> passwordCheck(String password);
    int insertMember(MemberDao memberDao);



}
