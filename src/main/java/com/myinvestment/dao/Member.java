package com.myinvestment.dao;


import lombok.Builder;
import javax.presistence.Id;
import lombok.Getter;


@Getter
@Builder
public class Member {


	private int id;
	private String email;
	private String nickname;
	private String password;

}
