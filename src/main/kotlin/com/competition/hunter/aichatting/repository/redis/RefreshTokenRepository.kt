package com.competition.hunter.aichatting.repository.redis

import com.competition.hunter.aichatting.domain.redis.RefreshToken
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshTokenRepository : CrudRepository<RefreshToken, String> {
}