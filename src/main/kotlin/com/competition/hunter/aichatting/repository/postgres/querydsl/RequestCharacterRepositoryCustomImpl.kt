package com.competition.hunter.aichatting.repository.postgres.querydsl

import com.competition.hunter.aichatting.domain.postgres.QRequestCharacter
import com.competition.hunter.aichatting.domain.postgres.RequestCharacter
import com.querydsl.jpa.impl.JPAQueryFactory

class RequestCharacterRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
): RequestCharacterRepositoryCustom {

    private val qRequestCharacter = QRequestCharacter.requestCharacter

    override fun getRequest(title: String, name: String): List<RequestCharacter> {
        return queryFactory
            .from(qRequestCharacter)
            .where(
                qRequestCharacter.workTitle.eq(title)
                    .and(
                        qRequestCharacter.characterName.eq(name)
                    )
            )
            .fetch() as List<RequestCharacter>
    }

    override fun existRequest(title: String, name: String): Boolean {
        return !getRequest(title, name).isEmpty()
    }

}