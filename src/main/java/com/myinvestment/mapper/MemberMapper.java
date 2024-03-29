package com.myinvestment.mapper;

import com.myinvestment.dao.Member;
import com.myinvestment.dto.request.MemberRequestDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    Member getMember(String email);
    String insertMember(MemberRequestDto member);

    int idCheck(String id);



}
