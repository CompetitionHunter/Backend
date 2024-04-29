package com.competition.hunter.aichatting.repository.postgres.querydsl;

import com.competition.hunter.aichatting.domain.postgres.QMember
import com.querydsl.jpa.impl.JPAQueryFactory

class MemberRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
): MemberRepositoryCustom {

    private val qMember = QMember.member
    override fun existByEmail(email: String): Boolean {
        var user = queryFactory
            .from(qMember)
            .where(
                qMember.email.eq(email)
            )
            .fetchFirst()

        return user != null
    }
}
