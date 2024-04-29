package com.competition.hunter.aichatting.dto

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.util.Date

data class SignUpDto (
    val email: String,
    val pw: String,
    val nickname: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    val birthday: Date
)