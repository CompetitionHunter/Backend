package com.competition.hunter.aichatting.repository.postgres.querydsl

import com.competition.hunter.aichatting.domain.postgres.Subscribe
import com.competition.hunter.aichatting.repository.postgres.SubscribeRepository

abstract class SubscribeRepositoryImpl : PostgresQuerydslSupport(Subscribe::class.java), SubscribeRepository {

}