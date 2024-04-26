package com.competition.hunter.aichatting.service.user

import com.competition.hunter.aichatting.dto.CharacterDto
import com.competition.hunter.aichatting.dto.WorkDto
import com.competition.hunter.aichatting.repository.postgres.CharacterRepository
import com.competition.hunter.aichatting.repository.postgres.WorkRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class CharacterService {

    private val characterRepository: CharacterRepository? = null

    private val workRepository: WorkRepository? = null

    fun getAllByPopular(): List<CharacterDto>? {
        return characterRepository?.findOrderBySubscribes()?.map { it.toCharacterDto() }
    }

    fun getAllGroupByWork(): List<WorkDto>? {
        return workRepository?.findGroupByWork()?.map { it.toWorkDto() }
    }

}