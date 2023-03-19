package com.ll.basic1.controller;

import com.ll.basic1.domain.Response;
import com.ll.basic1.domain.Rq;
import com.ll.basic1.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/login")
    @ResponseBody
    public Response login(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {

        Cookie cookieUsername = new Cookie("username", username);

        Rq rq = new Rq(request, response);

        Response responseData = memberService.login(username, password);

        if (responseData.getResultCode().equals("S-1")) {
            rq.setCookie("username", username);
        }

        return responseData;


    }

    @GetMapping("/member/join")
    @ResponseBody
    public Response join(@RequestParam String username, @RequestParam String password) {
        return memberService.join(username, password);
    }

    @GetMapping("/member/me")
    @ResponseBody
    public Response myPage(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();


        Rq rq = new Rq(request, response);

        String username = rq.getCookie("username", "없음");

        if (!username.equals("없음")) {
            // 쿠키에서 username 값을 가져왔을 때 처리할 내용
            return Response.successMypage(username);

        } else {
            return Response.failMypage();
        }


    }

    @GetMapping("/member/logout")
    @ResponseBody
    public Response logout(HttpServletRequest request, HttpServletResponse response) {

        Rq rq = new Rq(request,response);
        rq.removeCookie("username");

        return Response.logout();

    }


}
