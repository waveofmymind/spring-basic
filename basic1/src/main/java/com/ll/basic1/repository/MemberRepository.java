package com.ll.basic1.repository;

import com.ll.basic1.domain.Member;
import com.ll.basic1.domain.Response;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepository {

    private final List<Member> memberList = new ArrayList<>();
//    private final List<Member> memberList = List.of(new Member("user1","1234"),
//            new Member("abc","12345"),
//            new Member("test","12346"),
//            new Member("love","12347"),
//            new Member("like","12348"),
//            new Member("giving","12349"),
//            new Member("thanks","123410"),
//            new Member("hello","123411"),
//            new Member("good","123412"),
//            new Member("peace","123413"));


    public void save(String username,String password) {
        memberList.add(Member.of(username,password));
    }

    public Member findByUsername(String username) {
        return memberList.stream()
                .filter(member -> member.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

}
