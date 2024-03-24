package com.myinvestment.service;


import com.myinvestment.dao.MemberDao;
import com.myinvestment.dto.LoginDto;
import com.myinvestment.dto.LoginResponseDto;
import com.myinvestment.dto.MemberDto;
import com.myinvestment.mapper.MemberMapper;
import com.myinvestment.utils.ErrorCode;
import com.myinvestment.utils.RequestException;
import com.myinvestment.utils.ResponseDto;
import com.myinvestment.utils.SessionConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class LoginService {

    public final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
    private final SessionConfig sessionConfig;



    @Transactional
    public void signup(MemberDto memberDto) {

        boolean Result = duplicatedId(memberDto.getEmail());
        if (Result) {
            throw new RequestException(ErrorCode.USER_DUPLICATION_409);
        }
        memberDto.setEncodedPwd(passwordEncoder.encode(memberDto.getPassword()));
        String memberDao =  memberMapper.insertMember(memberDto);

    }

    public boolean duplicatedId(String id) {
        return memberMapper.idCheck(id)==1;
    }


    @Transactional
    public ResponseDto<LoginResponseDto> login(LoginDto loginDto, HttpServletResponse response) {

        MemberDao member = memberMapper.getMember(loginDto.getEmail());
        if(member == null) {
            throw new RequestException(ErrorCode.LOGIN_NOT_FOUND_404);

        if(!passwordEncoder.matches(loginDto.getPassword(), member.getPassword())) {
            throw new RequestException(ErrorCode.LOGIN_NOT_FOUND_404);
        }
        sessionConfig.createSession(response);


        }
}
