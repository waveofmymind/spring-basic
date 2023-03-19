package com.ll.basic1.domain;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public class Rq {

    private final HttpServletRequest request;

    private final HttpServletResponse response;

    public void setCookie(String cookieName, String value) {
        Cookie cookieUsername = new Cookie(cookieName, value);

        response.addCookie(cookieUsername);
    }

    public String getCookie(String targetName, String defaultValue) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(targetName)) {

                    return cookie.getValue();
                }
            }
        }
        return defaultValue;
    }

    public void removeCookie(String targetName) {

        if (request.getCookies() != null) {
            Arrays.stream(request.getCookies())
                    .filter(cookie -> cookie.getName().equals("username"))
                    .forEach(cookie -> {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    });
        }
    }
}
