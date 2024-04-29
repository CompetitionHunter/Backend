package com.competition.hunter.aichatting.repository.postgres;

import com.competition.hunter.aichatting.domain.postgres.Member
import com.competition.hunter.aichatting.repository.postgres.querydsl.MemberRepositoryCustom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Long>, MemberRepositoryCustom {

}
