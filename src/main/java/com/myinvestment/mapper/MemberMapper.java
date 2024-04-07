package com.myinvestment.mapper;

import com.myinvestment.dao.MemberDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    Optional<MemberDao> getMember(String email);
    int insertMember(MemberDao memberDao);

    int idCheck(String id);


}
