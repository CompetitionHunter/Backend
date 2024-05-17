package com.competition.hunter.aichatting.service.admin

import com.competition.hunter.aichatting.config.WebClientConfig
import com.competition.hunter.aichatting.domain.util.RequestStatus
import com.competition.hunter.aichatting.dto.RequestCharacterDto
import com.competition.hunter.aichatting.repository.postgres.CharacterRepository
import com.competition.hunter.aichatting.repository.postgres.RequestCharacterRepository
import com.competition.hunter.aichatting.repository.postgres.WorkRepository
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
@RequiredArgsConstructor
class ManageService(
    private val flaskService: FlaskService,
    private val requestCharacterRepository: RequestCharacterRepository
) {
    fun getRequestCharacters(): List<RequestCharacterDto>  {
        return requestCharacterRepository.getRequestByStatus(RequestStatus.REQUEST).map { it.toRequestCharacterDto() }
    }

    fun getRejectCharacters(): List<RequestCharacterDto>  {
        return requestCharacterRepository.getRequestByStatus(RequestStatus.REJECT).map { it.toRequestCharacterDto() }
    }

    fun getApproveCharacters(): List<RequestCharacterDto> {
        return requestCharacterRepository.getRequestByStatus(RequestStatus.APPROVE).map { it.toRequestCharacterDto() }
    }

    fun rejectRequestCharacter(id: Long): ResponseEntity<Map<String, String>> {
        if (!existRequestCharacter(id)) {
            return ResponseEntity.status(400).body(mapOf("result" to "fail"))
        }

        val requestCharacter = requestCharacterRepository.getRequestById(id)
        requestCharacter!!.rejectRequest()
        requestCharacterRepository.save(requestCharacter)

        return ResponseEntity.ok().body(mapOf("result" to "success"))
    }

    fun approveRequestCharacter(id: Long, urls: List<String>): HttpEntity<Map<String, String>> {
        if (!existRequestCharacter(id) || urls.isEmpty()) {
            return ResponseEntity.status(400).body(mapOf("result" to "fail"))
        }

        val requestCharacter = requestCharacterRepository.getRequestById(id)
        requestCharacter!!.approveRequest()
        requestCharacterRepository.save(requestCharacter)

        if (!flaskService.learnCharacterInfo(urls)) {
            return ResponseEntity.ok().body(mapOf("result" to "fail"))
        }
        return ResponseEntity.ok().body(mapOf("result" to "success"))
    }

    private fun existRequestCharacter(id: Long): Boolean {
        if (requestCharacterRepository.existRequestById(id)) return true
        return false
    }

}