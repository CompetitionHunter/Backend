package com.competition.hunter.aichatting.controller

import com.competition.hunter.aichatting.dto.SignInDto
import com.competition.hunter.aichatting.dto.SignUpDto
import com.competition.hunter.aichatting.service.member.AuthService
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {

    @PostMapping("/signUp")
    fun signUp(@RequestBody dto: SignUpDto) : ResponseEntity<Map<String, String>> {
        return authService.signUp(dto)
    }

    @PostMapping("/login")
    fun login(@RequestBody dto: SignInDto, response: HttpServletResponse): ResponseEntity<Map<String, String>> {
        return authService.login(dto, response)
    }

    @GetMapping("/logout")
    fun logout(reqest: HttpServletRequest, response: HttpServletResponse): ResponseEntity<Map<String, String>> {
        return authService.logout(reqest, response)
    }
}