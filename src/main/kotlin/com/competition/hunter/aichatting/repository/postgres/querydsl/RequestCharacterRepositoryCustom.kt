package com.competition.hunter.aichatting.repository.postgres.querydsl

import com.competition.hunter.aichatting.domain.postgres.RequestCharacter
import com.competition.hunter.aichatting.domain.util.RequestStatus

interface RequestCharacterRepositoryCustom {

    fun getRequestByTitleAndName(title: String, name: String): List<RequestCharacter>

    fun existRequest(title: String, name: String): Boolean

    fun getRequestByStatus(status: RequestStatus): List<RequestCharacter>

}