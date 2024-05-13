package com.competition.hunter.aichatting.service.admin

import com.competition.hunter.aichatting.domain.util.RequestStatus
import com.competition.hunter.aichatting.dto.RequestCharacterDto
import com.competition.hunter.aichatting.repository.postgres.CharacterRepository
import com.competition.hunter.aichatting.repository.postgres.RequestCharacterRepository
import com.competition.hunter.aichatting.repository.postgres.WorkRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class ManageService(
    private val requestCharacterRepository: RequestCharacterRepository
) {
    fun getRequestCharacters(): List<RequestCharacterDto>  {
        return requestCharacterRepository.getRequestByStatus(RequestStatus.REQUEST).map { it.toRequestCharacterDto() }
    }

    fun getRejectCharacters(): List<RequestCharacterDto>  {
        return requestCharacterRepository.getRequestByStatus(RequestStatus.REJECT).map { it.toRequestCharacterDto() }
    }
}