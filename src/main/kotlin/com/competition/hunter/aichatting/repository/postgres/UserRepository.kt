package com.competition.hunter.aichatting.repository.postgres;

import com.competition.hunter.aichatting.domain.postgres.User
import com.competition.hunter.aichatting.repository.postgres.querydsl.UserRepositoryCustom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.stereotype.Repository;

@Repository
@NoRepositoryBean
interface UserRepository : JpaRepository<User, Long>, UserRepositoryCustom {

}
