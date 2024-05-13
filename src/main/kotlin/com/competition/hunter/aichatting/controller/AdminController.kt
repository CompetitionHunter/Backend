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
    fun getRequestCharacters(req: HttpServletRequest): List<RequestCharacterDto> {
        return manageService.getRequestCharacters()
    }

     @GetMapping("/character/reject")
     fun getRejectCharacters(req: HttpServletRequest): List<RequestCharacterDto> {
         return manageService.getRejectCharacters()
     }

    @GetMapping("/character/approve")
    fun getApproveCharacters(req: HttpServletRequest): List<RequestCharacterDto> {
        return manageService.getApproveCharacters()
    }

}