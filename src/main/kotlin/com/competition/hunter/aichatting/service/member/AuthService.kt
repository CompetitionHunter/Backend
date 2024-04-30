package com.competition.hunter.aichatting.service.member

import com.competition.hunter.aichatting.auth.JwtGenerator
import com.competition.hunter.aichatting.auth.JwtProvider
import com.competition.hunter.aichatting.domain.postgres.Member
import com.competition.hunter.aichatting.domain.redis.RefreshToken
import com.competition.hunter.aichatting.dto.SignInDto
import com.competition.hunter.aichatting.dto.SignUpDto
import com.competition.hunter.aichatting.repository.postgres.MemberRepository
import com.competition.hunter.aichatting.repository.redis.RefreshTokenRepository
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.regex.Pattern

@Service
class AuthService(
    private val memberRepository: MemberRepository,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtGenerator: JwtGenerator,
    private val jwtProvider: JwtProvider
) {

    fun signUp(dto: SignUpDto): String {
        if (!validateSignUp(dto)) {
            return "fail"
        }

        memberRepository.save(
            Member(
                dto.email,
                dto.pw,
                dto.nickname,
                dto.birthday
            )
        )

        return "success"
    }

    fun login(dto: SignInDto, response: HttpServletResponse): ResponseEntity<Map<String, String>> {
        if (!validateSignIn(dto)) {
            return ResponseEntity.badRequest().body(mapOf("result" to "fail"))
        }

        var refresh = jwtGenerator.createRefreshToken(dto.email, "user")

        jwtGenerator.setHeaderAccessToken(response, dto.email, "user")
        jwtGenerator.setHeaderRefreshToken(response, refresh)
        refreshTokenRepository.save(RefreshToken(dto.email, refresh))

        return ResponseEntity.ok().body(mapOf("result" to "success"))
    }

    private fun validateSignIn(dto: SignInDto): Boolean {
        if (memberRepository.existByEmailAndPw(dto.email, dto.pw)) return true
        return false
    }

    private fun validateSignUp(dto: SignUpDto): Boolean {
        if (memberRepository.existByEmail(dto.email)) return false
        if (dto.email==null || dto.pw==null || dto.nickname== null || dto.birthday==null) return false
        if (!Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$").matcher(dto.email).matches()) return false

        return true
    }
}