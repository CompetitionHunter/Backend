package com.competition.hunter.aichatting.repository.postgres.querydsl

import com.querydsl.jpa.impl.JPAQueryFactory

class RequestCharacterRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
): RequestCharacterRepositoryCustom {

}