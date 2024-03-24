package com.myinvestment.mapper;

import com.myinvestment.dao.MemberDao;
import com.myinvestment.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    MemberDao getMember(String email);
    String insertMember(MemberDto member);

    int idCheck(String id);



}
