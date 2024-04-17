package com.competition.hunter.aichatting.domain.postgres

import com.competition.hunter.aichatting.repository.postgres.UserRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.util.*

@DataJpaTest
class UserTest {

    @Autowired
    val userRepository: UserRepository? = null

    @Test
    @DisplayName("User가 DB에 잘 저장되는지 확인")
    fun saveUserTest() {
        var user = User("test@test.com", "asdf", "asdf", Date(2024, 4, 5))

        var saveUser = userRepository?.save(user)

        Assertions.assertThat(saveUser?.id).isEqualTo(1)
        Assertions.assertThat(saveUser?.email).isEqualTo(user.email)
        Assertions.assertThat(saveUser?.nickname).isEqualTo(user.nickname)
        Assertions.assertThat(saveUser?.birthday).isEqualTo(user.birthday)
        Assertions.assertThat(saveUser?.suspended).isEqualTo(user.suspended)
    }

}