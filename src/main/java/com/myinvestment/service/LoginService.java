package com.myinvestment.service;

import com.myinvestment.domain.Member;
import com.myinvestment.domain.MemberRequest;
import com.myinvestment.dto.ResponseDto;
import com.myinvestment.exception.ErrorCode;
import com.myinvestment.exception.RequestException;
import com.myinvestment.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        return ResponseDto.success(
                memberRequest.getEmail());
    }


    @Transactional
    public ResponseDto login(String email, String password) {

        Member member = memberMapper.memberCheck(email).orElseThrow(
                () -> new RequestException(ErrorCode.ACCOUNT_NOT_FOUND)

        );
        passwordCheck(password).ifPresent(Member -> {
            throw new RequestException(ErrorCode.LOGIN_FAILED);
        });

        return ResponseDto.success(
                member.getEmail());
    }

    private void validateDuplication(MemberRequest memberRequest) {
        memberMapper.getMember(memberRequest.getEmail()).ifPresent(member -> {
            throw new RequestException(ErrorCode.USER_DUPLICATION);
        });
    }

    public Optional<Member> passwordCheck(String password) {
        return memberMapper.passwordCheck(password);
    }
}
