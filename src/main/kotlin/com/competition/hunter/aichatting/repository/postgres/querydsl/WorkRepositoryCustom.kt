package com.competition.hunter.aichatting.repository.postgres.querydsl

interface WorkRepositoryCustom {
    fun existsByTitle(title: String): Boolean
}