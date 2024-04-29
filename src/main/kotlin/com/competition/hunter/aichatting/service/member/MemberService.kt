package com.competition.hunter.aichatting.service.member

import com.competition.hunter.aichatting.domain.postgres.Member
import com.competition.hunter.aichatting.dto.SignInDto
import com.competition.hunter.aichatting.dto.SignUpDto
import com.competition.hunter.aichatting.repository.postgres.MemberRepository
import org.springframework.stereotype.Service
import java.util.regex.Pattern

@Service
class MemberService(
    private val memberRepository: MemberRepository
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

    fun signIn(dto: SignInDto): String {
        if (!validateSignIn(dto)) {
            return "fail"
        }

        return "success"
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