package com.competition.hunter.aichatting.auth

import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.UnsupportedJwtException
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import io.jsonwebtoken.security.SecurityException
import jakarta.annotation.PostConstruct
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.Date
import javax.crypto.SecretKey

@Component
class JwtProvider(@Value("\${jwt.key}") private val secretKey: String, private val userDetailService: UserDetailService) {

    private lateinit var key: SecretKey

    @PostConstruct
    protected fun init() {
        key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey))
    }

    fun validateToken(token: String): Boolean {
        try {
            var claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)

            return !claims.payload.expiration.before(Date())

        } catch (e: SecurityException) {
            System.out.println("["+e+"] Invalid JWT Token")
        } catch (e: ExpiredJwtException) {
            System.out.println("["+e+"] Expired JWT Token")
        } catch (e: UnsupportedJwtException) {
            System.out.println("["+e+"] Unsupported JWT Token")
        } catch (e: IllegalStateException) {
            System.out.println("["+e+"] JWT claims string is empty")
        }

        return false
    }

    fun getToken(request: HttpServletRequest): String? {
        return request.getHeader("Authorization")
    }

    fun getAuthentication(token: String): Authentication {
        val userDetails = userDetailService.loadUserByUsername(getUserEmail(token))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails?.authorities)
    }

    fun getUserEmail(token: String): String {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).payload.subject
    }

}