package com.competition.hunter.aichatting.repository.postgres.querydsl

import com.competition.hunter.aichatting.domain.postgres.RequestCharacter
import com.competition.hunter.aichatting.repository.postgres.RequestCharacterRepository

abstract class RequestCharacterRepositoryImpl : PostgresQuerydslSupport(RequestCharacter::class.java),
    RequestCharacterRepositoryCustom {

}