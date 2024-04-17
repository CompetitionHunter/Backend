package com.competition.hunter.aichatting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class AichattingApplication

fun main(args: Array<String>) {
	runApplication<AichattingApplication>(*args)
}
