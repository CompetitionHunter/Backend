package com.competition.hunter.aichatting.repository.postgres.querydsl

import com.competition.hunter.aichatting.domain.postgres.Work
import com.competition.hunter.aichatting.repository.postgres.WorkRepository

abstract class WorkRepositoryImpl : PostgresQuerydslSupport(Work::class.java), WorkRepository {

}