package com.competition.hunter.aichatting.controller

import com.competition.hunter.aichatting.dto.CharacterDto
import com.competition.hunter.aichatting.service.admin.CharacterService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/character")
class CharacterController {

    private val characterService = CharacterService();

    @GetMapping("/popular")
    fun getAllByPopular(): List<CharacterDto>? {
        return characterService.getAllByPopular()
    }

}