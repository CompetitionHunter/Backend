package com.competition.hunter.aichatting.repository.postgres.querydsl;

import com.competition.hunter.aichatting.domain.postgres.User
import com.competition.hunter.aichatting.repository.postgres.UserRepository

abstract class UserRepositoryImpl : PostgresQuerydslSupport(User::class.java), UserRepositoryCustom {

}
