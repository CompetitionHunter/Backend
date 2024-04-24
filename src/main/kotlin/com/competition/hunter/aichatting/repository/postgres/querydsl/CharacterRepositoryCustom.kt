package com.competition.hunter.aichatting.repository.postgres.querydsl

import com.competition.hunter.aichatting.domain.postgres.Character

interface CharacterRepositoryCustom {
    fun existsByName(name: String): Boolean

    fun findOrderBySubscribes(): List<Character>
}