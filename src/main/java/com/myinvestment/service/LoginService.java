package com.myinvestment.service;


import com.myinvestment.dao.MemberDao;
import com.myinvestment.dto.request.LoginRequestDto;
import com.myinvestment.dto.request.MemberRequestDto;
import com.myinvestment.dto.response.LoginResponseDto;
import com.myinvestment.mapper.MemberMapper;
//import com.myinvestment.utils.SessionConfig;
import com.myinvestment.utils.DuplicateException;
import com.myinvestment.utils.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    public final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
//    private final SessionConfig sessionConfig;

    @Transactional
    public void signup(MemberRequestDto memberRequestDto) {

        //member 중복 검사
        isDuplicatedMember(memberRequestDto.getEmail()).ifPresent(member -> {
            throw new DuplicateException(ErrorCode.USER_DUPLICATION_409);
        });
        //member 생성
        memberRequestDto.setEncodedPwd(passwordEncoder.encode(memberRequestDto.getPassword()));
        MemberDao memberDao = MemberDao.builder()
                .email(memberRequestDto.getEmail())
                .nickname(memberRequestDto.getNickname())
                .password(memberRequestDto.getPassword())
                .build();

        memberMapper.insertMember(memberDao);
    }


    public Optional<MemberDao> isDuplicatedMember(String email) {

        return memberMapper.getMember(email);
//        return Optional.ofNullable(memberMapper.getMember(email));
    }


//    @Transactional
//    public ResponseEntity<LoginResponseDto> login(LoginRequestDto loginRequestDto) {
//
//        //이메일 확인
//        isDuplicatedMember(LoginRequestDto.
//
//
//        isDuplicatedMember(memberRequestDto.getEmail()).ifPresent(member -> {
//            throw new DuplicateException(ErrorCode.USER_DUPLICATION_409);
//        });
//
//        return ResponseEntity.ok(
//                LoginResponseDto.builder()
//                        .email(member.getEmail())
//                        .build()
//        );
//        }
}
