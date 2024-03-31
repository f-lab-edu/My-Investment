package com.myinvestment.mapper;

import com.myinvestment.dao.Member;
import com.myinvestment.dao.MemberDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    Member getMember(String email);
    String insertMember(MemberDao member);

    int idCheck(String id);



}
