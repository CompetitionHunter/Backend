package com.competition.hunter.aichatting.service.member

import com.competition.hunter.aichatting.auth.JwtProvider
import com.competition.hunter.aichatting.domain.postgres.RequestCharacter
import com.competition.hunter.aichatting.dto.RequestCharacterDto
import com.competition.hunter.aichatting.repository.postgres.CharacterRepository
import com.competition.hunter.aichatting.repository.postgres.RequestCharacterRepository
import com.competition.hunter.aichatting.repository.postgres.WorkRepository
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class RequestService(
    private val characterRepository: CharacterRepository,
    private val workRepository: WorkRepository,
    private val requestCharacterRepository: RequestCharacterRepository,
    private val jwtProvider: JwtProvider
) {

    fun addNewCharacter(dto: RequestCharacterDto, req: HttpServletRequest): ResponseEntity<Map<String, String>> {
        val title = dto.title.replace(Regex("\\s"), "")
        val name = dto.name.replace(Regex("\\s"), "")

        if (existRequest(title, name) || existCharacter(title, name)) {
            return ResponseEntity.status(400).body(mapOf("result" to "fail"))
        }

        requestCharacterRepository.save(
            RequestCharacter(
                jwtProvider.getUserEmail(jwtProvider.getAccessToken(req)!!),
                title,
                name
            )
        )
        return ResponseEntity.ok().body(mapOf("result" to "success"))
    }

    private fun existRequest(title: String, name: String): Boolean {
        if (requestCharacterRepository.existRequest(title, name)) return true
        return false
    }

    private fun existCharacter(title: String, name: String): Boolean {
        val work = workRepository.getByTitle(title).orElseGet( return false )
        if (characterRepository.existsByTitleAndName(work, name)) return true
        return false
    }
}