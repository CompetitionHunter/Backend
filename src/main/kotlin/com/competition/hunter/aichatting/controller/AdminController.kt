package com.competition.hunter.aichatting.controller

import com.competition.hunter.aichatting.dto.RequestCharacterDto
import com.competition.hunter.aichatting.service.admin.ManageService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpEntity
import org.springframework.web.bind.annotation.*

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

    @GetMapping("/request/reject/{id}")
    fun rejectRequestCharacter(@PathVariable("id") id: Long, req: HttpServletRequest): HttpEntity<Map<String, String>> {
        return manageService.rejectRequestCharacter(id)
    }

    @PostMapping("/request/approve/{id}")
    fun approveRequestCharacter(@PathVariable("id") id: Long, @RequestBody urls: List<String>, req: HttpServletRequest): HttpEntity<Map<String, String>> {
        return manageService.approveRequestCharacter(id, urls)
    }

}