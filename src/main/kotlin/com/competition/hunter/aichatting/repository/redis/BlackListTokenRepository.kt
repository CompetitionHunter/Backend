package com.competition.hunter.aichatting.repository.redis

import com.competition.hunter.aichatting.domain.redis.BlackListToken
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BlackListTokenRepository: CrudRepository<BlackListToken, String> {
}