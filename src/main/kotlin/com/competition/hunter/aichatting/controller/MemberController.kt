package com.competition.hunter.aichatting.controller

import com.competition.hunter.aichatting.dto.SignUpDto
import com.competition.hunter.aichatting.service.member.MemberService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class MemberController(
    private val memberService: MemberService
) {

    @PostMapping("/signUp")
    fun signUp(@RequestBody dto: SignUpDto) : String {
        return memberService.signUp(dto)
    }
}