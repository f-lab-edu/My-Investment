package com.myinvestment.utils;


import com.myinvestment.dao.Member;
import com.myinvestment.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    private final MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Member member = memberMapper.getMember(email).
                orElseThrow(() -> new RuntimeException("Not Found Account")
                );
        return createUserDetails(member);
    }

    private UserDetails createUserDetails(Member member) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("member");

        return new User(
                member.getEmail(),
                member.getPassword(),
                Collections.singleton(grantedAuthority)
        );
    }

//        isDuplicatedMember(memberMapper.getMember(email)).orElseThrow()
    }

//    isDuplicatedMember(memberRequestDto.getEmail()).ifPresent(member -> {
//        throw new RuntimeException();
//    });
//
//    public Optional<Member> isDuplicatedMember(String email) {
//        return Optional.ofNullable(memberMapper.getMember(email));
//    }

