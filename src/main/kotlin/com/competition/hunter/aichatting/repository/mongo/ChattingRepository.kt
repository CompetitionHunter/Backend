package com.competition.hunter.aichatting.repository.mongo

import com.competition.hunter.aichatting.domain.mongo.Chatting
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ChattingRepository : MongoRepository<Chatting, Long> {
}