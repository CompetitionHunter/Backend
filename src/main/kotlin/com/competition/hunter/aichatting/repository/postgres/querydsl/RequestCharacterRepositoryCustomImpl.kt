package com.competition.hunter.aichatting.repository.postgres.querydsl

import com.competition.hunter.aichatting.domain.postgres.QRequestCharacter
import com.competition.hunter.aichatting.domain.postgres.RequestCharacter
import com.competition.hunter.aichatting.domain.util.RequestStatus
import com.querydsl.jpa.impl.JPAQueryFactory

class RequestCharacterRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
): RequestCharacterRepositoryCustom {

    private val qRequestCharacter = QRequestCharacter.requestCharacter

    override fun getRequestByTitleAndName(title: String, name: String): List<RequestCharacter> {
        return queryFactory
            .from(qRequestCharacter)
            .where(
                qRequestCharacter.workTitle.eq(title),
                qRequestCharacter.characterName.eq(name)
            )
            .fetch() as List<RequestCharacter>
    }

    override fun existRequestByTitleAndName(title: String, name: String): Boolean {
        return !getRequestByTitleAndName(title, name).isEmpty()
    }


    override fun getRequestByStatus(status: RequestStatus): List<RequestCharacter> {
        return queryFactory
            .from(qRequestCharacter)
            .where(
                qRequestCharacter.requestStatus.eq(status)
            )
            .fetch() as List<RequestCharacter>
    }

    override fun getRequestById(id: Long): RequestCharacter? {
        return queryFactory
            .from(qRequestCharacter)
            .where(
                qRequestCharacter.id.eq(id)
            )
            .fetchOne() as RequestCharacter?
    }

    override fun existRequestById(id: Long): Boolean {
        return getRequestById(id) != null
    }
}