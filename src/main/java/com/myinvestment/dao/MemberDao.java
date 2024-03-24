package com.myinvestment.dao;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class MemberDao {


    private int id;
    private String email;
    private String password;


}
