package com.competition.hunter.aichatting.repository.postgres.querydsl

import com.competition.hunter.aichatting.domain.postgres.Character
import com.competition.hunter.aichatting.repository.postgres.CharacterRepository

abstract class CharacterRepositoryImpl : PostgresQuerydslSupport(Character::class.java), CharacterRepository {

}