package com.competition.hunter.aichatting.controller

import com.competition.hunter.aichatting.dto.RequestCharacterDto
import com.competition.hunter.aichatting.service.admin.ManageService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/admin")
class AdminController(private val manageService: ManageService) {

    @GetMapping("/character/request")
    fun getAllRequestCharacter(req: HttpServletRequest): List<RequestCharacterDto> {
        return manageService.getRequestCharacters()
    }

     @GetMapping("/character/reject")
     fun getAllRejectCharacter(req: HttpServletRequest): List<RequestCharacterDto> {
         return manageService.getRejectCharacters()
     }

}