package com.competition.hunter.aichatting.repository.postgres

import com.competition.hunter.aichatting.domain.postgres.Work
import com.competition.hunter.aichatting.repository.postgres.querydsl.WorkRepositoryCustom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface WorkRepository : JpaRepository<Work, Long>, WorkRepositoryCustom {

    fun getByTitle(title: String): Optional<Work>

}