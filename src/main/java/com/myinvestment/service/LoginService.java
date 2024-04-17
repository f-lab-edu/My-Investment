package com.myinvestment.service;

import com.myinvestment.domain.*;
import com.myinvestment.dto.ResponseDto;
import com.myinvestment.mapper.MemberMapper;
import com.myinvestment.exception.DuplicateException;
import com.myinvestment.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public ResponseDto signup(MemberRequest memberRequest) {
        //member 중복 검사
        validateDuplication(memberRequest);

        //member 생성
        memberMapper.insertMember(Member.builder()
                .email(memberRequest.getEmail())
                .nickname(memberRequest.getNickname())
                .password(passwordEncoder.encode(memberRequest.getPassword()))
                .build());

        return new ResponseDto(memberRequest.getEmail());
    }


    @Transactional
    public ResponseDto login(LoginRequest loginRequest) {

        Member member = memberMapper.memberCheck(loginRequest.getEmail()).orElseThrow(
                ()-> new DuplicateException(ErrorCode.LOGIN_NOT_FOUND_404)

        );
        passwordCheck(loginRequest.getPassword()).ifPresent(Member -> {
            throw new DuplicateException(ErrorCode.LOGIN_NOT_FOUND_404);
        });

        return new ResponseDto(loginRequest.getEmail()) ;
        }

    private void validateDuplication(MemberRequest memberRequest) {
        memberMapper.getMember(memberRequest.getEmail()).ifPresent(member -> {
            throw new DuplicateException(ErrorCode.USER_DUPLICATION_409);
        });
    }
    public Optional<Member> passwordCheck(String password) {
        return memberMapper.passwordCheck(password);
    }
}
