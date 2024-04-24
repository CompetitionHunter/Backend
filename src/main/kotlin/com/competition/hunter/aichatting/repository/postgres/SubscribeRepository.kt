package com.competition.hunter.aichatting.repository.postgres

import com.competition.hunter.aichatting.domain.postgres.Subscribe
import com.competition.hunter.aichatting.repository.postgres.querydsl.SubscribeRepositoryCustom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.stereotype.Repository

@Repository
@NoRepositoryBean
interface SubscribeRepository : JpaRepository<Subscribe, Long>, SubscribeRepositoryCustom {
}