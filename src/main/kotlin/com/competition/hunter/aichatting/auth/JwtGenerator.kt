package com.competition.hunter.aichatting.auth

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import jakarta.annotation.PostConstruct
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtGenerator(@Value("\${jwt.key}") private val secretKey: String) {

    private val accessTokenValidTime = 24 * 60 * 60 * 1000L // 24시간
    private val refreshTokenValidTime = 7 * 24 * 60 * 60 * 1000L // 일주일

    private lateinit var key: SecretKey

    @PostConstruct
    protected fun init() {
        key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey))
    }

    fun setHeaderAccessToken(response: HttpServletResponse, email: String, role: String) {
        response.setHeader("Authorization", createAccessToken(email, role))
    }

    fun setHeaderRefreshToken(response: HttpServletResponse, token: String) {
        response.setHeader("RefreshToken", "bearer "+token)
    }

    fun createRefreshToken(email: String, role: String): String {
        return generateToken(email, role, refreshTokenValidTime)
    }

    private fun createAccessToken(email: String, role: String): String {
        return generateToken(email, role, accessTokenValidTime)
    }

    private fun generateToken(email: String, role: String, tokenValidate: Long): String {
        return Jwts.builder()
            .subject(email)
            .issuedAt(Date(Date().time))
            .claims(mutableMapOf<String, String>("role" to role))
            .expiration(Date(Date().time + tokenValidate))
            .signWith(key)
            .compact()
    }

}