package com.competition.hunter.aichatting.repository.postgres.querydsl

import com.competition.hunter.aichatting.domain.postgres.QWork
import com.competition.hunter.aichatting.domain.postgres.Work
import com.competition.hunter.aichatting.repository.postgres.WorkRepository
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.JPQLQuery
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Repository


abstract class WorkRepositoryImpl : PostgresQuerydslSupport(Work::class.java), WorkRepositoryCustom {

    private val qWork = QWork.work

    override fun existsByTitle(title: String): Boolean {
        var work = from(qWork)
            .where(
                qWork.title.eq(title)
            )
            .fetchFirst()

        return work != null
    }

    override fun findGroupByWork(): List<Work> {
        return from(qWork)
            .groupBy(
                qWork.title
            )
            .fetch()
    }

}