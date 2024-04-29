package com.competition.hunter.aichatting.repository.postgres.querydsl

interface MemberRepositoryCustom {

    fun existByEmail(email: String): Boolean

    fun existByEmailAndPw(email: String, pw: String): Boolean

}