package com.competition.hunter.aichatting.domain.redis

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash


@RedisHash("refresh")
data class RefreshToken (
    @Id
    val email: String,
    val refresh: String
)