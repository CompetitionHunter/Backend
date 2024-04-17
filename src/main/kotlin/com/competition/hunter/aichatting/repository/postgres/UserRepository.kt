package com.competition.hunter.aichatting.repository.postgres;

import com.competition.hunter.aichatting.domain.postgres.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository : JpaRepository<User, Long> {

}
