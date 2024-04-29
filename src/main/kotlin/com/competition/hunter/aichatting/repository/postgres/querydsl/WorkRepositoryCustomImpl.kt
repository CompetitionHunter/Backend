package com.competition.hunter.aichatting.repository.postgres.querydsl

import com.competition.hunter.aichatting.domain.postgres.QWork
import com.competition.hunter.aichatting.domain.postgres.Work
import com.querydsl.jpa.impl.JPAQueryFactory


class WorkRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
): WorkRepositoryCustom {

    private val qWork = QWork.work

    override fun existsByTitle(title: String): Boolean {
        var work = queryFactory
            .from(qWork)
            .where(
                qWork.title.eq(title)
            )
            .fetchFirst()

        return work != null
    }

    override fun findGroupByWork(): List<Work> {
        return queryFactory
            .from(qWork)
            .groupBy(
                qWork.title
            )
            .fetch() as List<Work>
    }

}