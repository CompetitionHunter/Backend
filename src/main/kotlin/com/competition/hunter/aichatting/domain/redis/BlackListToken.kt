package com.competition.hunter.aichatting.domain.redis

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("blacklist")
data class BlackListToken(
    @Id
    val email: String,
    val blacklist: String
)
