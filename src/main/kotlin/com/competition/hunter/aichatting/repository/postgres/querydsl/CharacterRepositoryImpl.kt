package com.competition.hunter.aichatting.repository.postgres.querydsl

import com.competition.hunter.aichatting.domain.postgres.Character
import com.competition.hunter.aichatting.domain.postgres.QCharacter
import com.competition.hunter.aichatting.dto.CharacterDto
import com.competition.hunter.aichatting.repository.postgres.CharacterRepository
import org.springframework.stereotype.Repository

abstract class CharacterRepositoryImpl : PostgresQuerydslSupport(Character::class.java), CharacterRepositoryCustom {

    private val qCharacter = QCharacter.character

    override fun existsByName(name: String): Boolean {
        var character = from(qCharacter)
            .where(
                qCharacter.name.eq(name)
            )
            .fetchFirst()

        return character != null
    }

    override fun findOrderBySubscribes(): List<Character> {
        return from(qCharacter)
            .orderBy(qCharacter.subscribes.size().desc())
            .fetch()
    }
}