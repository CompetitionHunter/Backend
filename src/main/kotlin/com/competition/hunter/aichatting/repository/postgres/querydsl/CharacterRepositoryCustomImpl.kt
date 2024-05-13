package com.competition.hunter.aichatting.repository.postgres.querydsl

import com.competition.hunter.aichatting.domain.postgres.Character
import com.competition.hunter.aichatting.domain.postgres.QCharacter
import com.competition.hunter.aichatting.domain.postgres.Work
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component

@Component
class CharacterRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
): CharacterRepositoryCustom {

    private val qCharacter = QCharacter.character

    override fun existsByName(name: String): Boolean {
        var character = queryFactory
            .from(qCharacter)
            .where(
                qCharacter.name.eq(name)
            )
            .fetchFirst()

        return character != null
    }

    override fun findOrderBySubscribes(): List<Character> {
        return queryFactory
            .from(qCharacter)
            .orderBy(qCharacter.subscribes.size().desc())
            .fetch() as List<Character>
    }

    override fun getByTitleAndName(work: Work, name: String): Character {
        return queryFactory
            .from(qCharacter)
            .where(
                qCharacter.work.eq(work),
                qCharacter.name.eq(name)
            )
            .fetchFirst() as Character
    }

    override fun existsByTitleAndName(work: Work, name: String): Boolean {
        return getByTitleAndName(work, name) != null
    }
}