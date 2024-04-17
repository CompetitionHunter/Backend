package com.competition.hunter.aichatting.domain.mongo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Document(collection = "chatting")
data class Chatting(

    val message: String

) {
    @Id
    var id: String? = null
        private set
    var date: String? = LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"))
        private set

}
