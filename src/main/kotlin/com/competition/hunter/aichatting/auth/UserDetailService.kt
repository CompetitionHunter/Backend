package com.competition.hunter.aichatting.auth

import com.competition.hunter.aichatting.repository.postgres.MemberRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailService(private val memberRepository: MemberRepository): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails? {
        return memberRepository.findByEmail(username)
    }
}