package com.ll.basic1.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {
    private static Long lastId;
    private Long id;

    private String username;

    private String password;

    static {
        lastId = 0L;
    }

    public static Member of(String username, String password) {
        return new Member(++lastId,username,password);
    }
}
