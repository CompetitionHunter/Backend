package com.competition.hunter.aichatting.service.admin

import com.competition.hunter.aichatting.dto.CharacterDto
import com.competition.hunter.aichatting.repository.postgres.CharacterRepository
import com.competition.hunter.aichatting.repository.postgres.WorkRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
@RequiredArgsConstructor
class CharacterService {

    private val characterRepository: CharacterRepository? = null

    private val workRepository: WorkRepository? = null

    fun getAllByPopular(): List<CharacterDto>? {
        return characterRepository?.findOrderBySubscribes()?.map { it.toCharacterDto() }
    }

}