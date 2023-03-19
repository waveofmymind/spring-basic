package com.example.basic1k.controller

import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController {

    fun memberTest() : String {
        return "안녕"
    }

    fun memberTest2() : String {
        return "안녕하세요"
    }
}