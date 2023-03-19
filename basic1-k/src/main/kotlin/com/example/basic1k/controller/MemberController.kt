package com.example.basic1k.controller

import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController {

    fun memberTest() : String {
        return "안녕"
    }
}