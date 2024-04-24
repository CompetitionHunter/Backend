package com.competition.hunter.aichatting.repository.postgres

import com.competition.hunter.aichatting.domain.postgres.Character
import com.competition.hunter.aichatting.dto.CharacterDto
import com.competition.hunter.aichatting.repository.postgres.querydsl.CharacterRepositoryCustom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.stereotype.Repository

@Repository
@NoRepositoryBean
interface CharacterRepository : JpaRepository<Character, Long>, CharacterRepositoryCustom {

}