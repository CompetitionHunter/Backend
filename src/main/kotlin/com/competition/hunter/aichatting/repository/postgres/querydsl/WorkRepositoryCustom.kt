package com.competition.hunter.aichatting.repository.postgres.querydsl

import com.competition.hunter.aichatting.domain.postgres.Work

interface WorkRepositoryCustom {
    fun existsByTitle(title: String): Boolean

    fun findGroupByWork(): List<Work>

}