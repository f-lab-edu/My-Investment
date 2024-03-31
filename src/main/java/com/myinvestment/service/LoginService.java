package com.myinvestment.service;


import com.myinvestment.dao.Member;
import com.myinvestment.dao.MemberDao;
import com.myinvestment.dto.request.MemberRequestDto;
import com.myinvestment.mapper.MemberMapper;
//import com.myinvestment.utils.SessionConfig;
import lombok.RequiredArgsConstructor;
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
            throw new RuntimeException();
        });
        //member 생성
        memberRequestDto.setEncodedPwd(passwordEncoder.encode(memberRequestDto.getPassword()));
        MemberDao memberDao = MemberDao.builder()
                .email(memberRequestDto.getEmail())
                .nickName(memberRequestDto.getNickName())
                .password(memberRequestDto.getPassword())
                .build();

        memberMapper.insertMember(memberDao);
    }


    public Optional<Member> isDuplicatedMember(String email) {
        return Optional.ofNullable(memberMapper.getMember(email));
    }


//    @Transactional
//    public ResponseDto<LoginResponseDto> login(LoginDto loginDto, HttpServletResponse response) {
//
//        MemberDao member = memberMapper.getMember(loginDto.getEmail());
//        if(member == null) {
//            throw new RequestException(ErrorCode.LOGIN_NOT_FOUND_404);
//
//        if(!passwordEncoder.matches(loginDto.getPassword(), member.getPassword())) {
//            throw new RequestException(ErrorCode.LOGIN_NOT_FOUND_404);
//        }
//        sessionConfig.createSession(response);
//
//
//        }
}
