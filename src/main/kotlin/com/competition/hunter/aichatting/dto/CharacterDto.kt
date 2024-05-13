package com.competition.hunter.aichatting.dto

data class CharacterDto (
    var id: Long,
    var title: String? = null,
    var name: String,
    var image: String? = null
)