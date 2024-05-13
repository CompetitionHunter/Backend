package com.competition.hunter.aichatting.controller

import com.competition.hunter.aichatting.dto.CharacterDto
import com.competition.hunter.aichatting.dto.RequestCharacterDto
import com.competition.hunter.aichatting.dto.WorkDto
import com.competition.hunter.aichatting.service.member.CharacterService
import com.competition.hunter.aichatting.service.member.RequestService
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/character")
class CharacterController(
    private val characterService: CharacterService,
    private val requestService: RequestService
) {

    @GetMapping("/popular")
    fun getAllByPopular(req: HttpServletRequest): List<CharacterDto>? {
        return characterService.getAllByPopular()
    }

    @GetMapping("/class")
    fun getAllGroupByWork(req: HttpServletRequest): List<WorkDto>? {
        return characterService.getAllGroupByWork()
    }

    @PostMapping("/new")
    fun addNewCharacter(@RequestBody dto: RequestCharacterDto, req: HttpServletRequest): ResponseEntity<Map<String, String>> {
        return requestService.addNewCharacter(dto, req)
    }

}