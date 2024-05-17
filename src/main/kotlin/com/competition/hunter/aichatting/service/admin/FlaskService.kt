package com.competition.hunter.aichatting.service.admin

import com.competition.hunter.aichatting.config.WebClientConfig
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
class FlaskService(private val webClientConfig: WebClientConfig) {

    fun learnCharacterInfo(urls: List<String>): Boolean {

        // TODO : 예외처리하기
        val data = webClientConfig.webClient()
            .post()
            .uri("/model/learn")
            .bodyValue(mapOf("urls" to urls))
            .retrieve()
            .bodyToMono(String::class.java)

        data.subscribe {
                res -> System.out.println(res)
        }

        return true
    }
}