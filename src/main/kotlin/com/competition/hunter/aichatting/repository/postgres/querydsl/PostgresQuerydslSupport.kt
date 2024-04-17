package com.competition.hunter.aichatting.repository.postgres.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository
import kotlin.properties.Delegates

@Repository
abstract class PostgresQuerydslSupport(domainClass: Class<*>) : QuerydslRepositorySupport(domainClass){

//     private var queryFactory: JPAQueryFactory by Delegates.notNull()

    @PersistenceContext(unitName = "postgresEntityManager")
    override fun setEntityManager(entityManager: EntityManager) {
        super.setEntityManager(entityManager)
    }

}
