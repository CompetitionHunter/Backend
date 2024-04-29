package com.competition.hunter.aichatting.repository.postgres.querydsl

import com.querydsl.jpa.impl.JPAQueryFactory

class SubscribeRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
): SubscribeRepositoryCustom {

}