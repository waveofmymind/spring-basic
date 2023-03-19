package com.ll.basic1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {

    private String resultCode;

    private String msg;

    private Object data;

    private boolean success;




    public static Response success(String username) {
        return new Response("S-1",String.format("%s님 환영합니다.",username),username,true);
    }
    public static Response successMypage(String username) {
        return new Response("S-2",String.format("닉네임이 %s입니다.",username),username,true);
    }

    public static Response invalidPassword() {
        return new Response("F-1","비밀번호가 일치하지 않습니다.",null,false);
    }

    public static Response invalidUsername(String username) {
        return new Response("F-2",String.format("%s는 존재하지 않는 회원입니다.",username),username,false);
    }

    public static Response failLogin() {
        return new Response("F-3","중복된 유저입니다.",null,false);
    }

    public static Response failMypage() {
        return new Response("F-4","로그인 후 이용해주세요",null,false);
    }


    public static Response logout() {
        return new Response("S-4","로그아웃 성공했습니다.",null,false);
    }
}
