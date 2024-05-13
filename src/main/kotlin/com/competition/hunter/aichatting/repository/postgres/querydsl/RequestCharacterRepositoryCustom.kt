package com.competition.hunter.aichatting.repository.postgres.querydsl

import com.competition.hunter.aichatting.domain.postgres.RequestCharacter

interface RequestCharacterRepositoryCustom {

    fun getRequest(title: String, name: String): List<RequestCharacter>

    fun existRequest(title: String, name: String): Boolean

}