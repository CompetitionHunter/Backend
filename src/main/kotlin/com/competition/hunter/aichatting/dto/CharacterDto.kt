package com.competition.hunter.aichatting.dto

data class CharacterDto (
    var id: Long,
    var name: String,
    var image: String? = null,
    var title: String? = null
)