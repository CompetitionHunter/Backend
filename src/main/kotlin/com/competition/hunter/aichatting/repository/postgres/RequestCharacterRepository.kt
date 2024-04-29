package com.competition.hunter.aichatting.repository.postgres

import com.competition.hunter.aichatting.domain.postgres.RequestCharacter
import com.competition.hunter.aichatting.repository.postgres.querydsl.RequestCharacterRepositoryCustom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RequestCharacterRepository : JpaRepository<RequestCharacter, Long>, RequestCharacterRepositoryCustom {
}