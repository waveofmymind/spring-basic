package com.ll.basic1.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;

@Controller
@RequestMapping("/home")
public class HomeController {

    private static int n = 0;

    @GetMapping("/main")
    @ResponseBody
    public String showMain() {
        return "안녕하세요.";
    }

    @GetMapping("/main2")
    @ResponseBody
    public String showMain2() {
        return "반갑습니다.";
    }

    @GetMapping("/main3")
    @ResponseBody
    public String showMain3() {
        return "즐거웠습니다.";
    }

    @GetMapping("/increase")
    @ResponseBody
    public int increase() {

        return n++;
    }

    @GetMapping("/plus")
    @ResponseBody
    public int plus(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    @GetMapping("/cookie/increase")
    @ResponseBody
    public int cookieIncrease(HttpServletRequest request, HttpServletResponse response) {
        int count = 0;

        if (request.getCookies() != null) {
            count = Arrays.stream(request.getCookies())
                    .filter(cookie -> cookie.getName().equals("count"))
                    .map(Cookie::getValue)
                    .mapToInt(Integer::parseInt)
                    .findFirst()
                    .orElse(0);
        }

        int newCount = count + 1;

        response.addCookie(new Cookie("count", newCount + ""));

        return newCount;
    }

}

