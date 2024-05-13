package com.competition.hunter.aichatting.repository.postgres.querydsl

import com.competition.hunter.aichatting.domain.postgres.Character
import com.competition.hunter.aichatting.domain.postgres.Work

interface CharacterRepositoryCustom {
    fun existsByName(name: String): Boolean

    fun findOrderBySubscribes(): List<Character>

    fun getByTitleAndName(work: Work, name: String): Character

    fun existsByTitleAndName(work: Work, name: String): Boolean
}