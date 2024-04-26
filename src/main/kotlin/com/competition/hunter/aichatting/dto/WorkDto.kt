package com.competition.hunter.aichatting.dto

data class WorkDto(
    var title: String,
    var profile: String,
    var characters: List<CharacterDto>? = null
)
