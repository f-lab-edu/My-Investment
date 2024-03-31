package com.myinvestment.service;

import com.myinvestment.dao.Member;
import com.myinvestment.mapper.MemberMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {





    @Mock
    MemberMapper memberMapper;


    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    LoginService loginService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void signup() {
        //given


        //when
        Member member = loginService.signup();

        //then
        assertThaat()
    }


}