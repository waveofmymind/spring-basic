package com.ll.basic1.service;

import com.ll.basic1.domain.Member;
import com.ll.basic1.domain.Response;
import com.ll.basic1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Response login(String username, String password) {
        Member findMember = memberRepository.findByUsername(username);

        if (findMember == null) {
            return Response.invalidUsername(username);
        } else {
            if (findMember.getPassword().equals(password)) {
                return Response.success(findMember.getUsername());
            } else {
                return Response.invalidPassword();
            }
        }
    }

    public Response join(String username, String password) {

        if (validateUser(username)) {
            memberRepository.save(username, password);
            return Response.success(username);
        } else {
            return Response.failLogin();
        }

    }

    private boolean validateUser(String username) {
        return memberRepository.findByUsername(username) == null;
    }
}
