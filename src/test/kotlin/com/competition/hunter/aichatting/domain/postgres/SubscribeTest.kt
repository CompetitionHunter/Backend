package com.competition.hunter.aichatting.domain.postgres

import com.competition.hunter.aichatting.repository.postgres.CharacterRepository
import com.competition.hunter.aichatting.repository.postgres.SubscribeRepository
import com.competition.hunter.aichatting.repository.postgres.UserRepository
import com.competition.hunter.aichatting.repository.postgres.WorkRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.text.SimpleDateFormat
import java.util.Date

@DataJpaTest
class SubscribeTest {

    @Autowired
    val subscribeRepository: SubscribeRepository? = null

    @Autowired
    val workRepository: WorkRepository? = null

    @Autowired
    val characterRepository: CharacterRepository? = null

    @Autowired
    val userRepository: UserRepository? = null

    @Test
    @DisplayName("Subscribe가 DB에 잘 저장되는지 확인")
    fun saveSubscribeTest() {
        var user = User("test@test.com", "test", "그적", Date(1999,12,29))
        var work = Work("가비지타임", "작품 사진 경로")
        var character1 = Character(work, "기상호", SimpleDateFormat("MM.dd").parse("1.11"), mutableListOf("허세", "귀여움"), "캐릭터 프로필 경로")
        var character2 = Character(work, "박병찬", SimpleDateFormat("MM.dd").parse("10.1"), mutableListOf("멋있음", "강철멘탈"), "캐릭터 프로필 경로")

        var saveUser = userRepository?.save(user)
        var saveWork = workRepository?.save(work)
        var saveCharacter1 = characterRepository?.save(character1)
        var saveCharacter2 = characterRepository?.save(character2)
        var saveSub1 = subscribeRepository?.save(Subscribe(saveUser, saveCharacter1))
        var saveSub2 = subscribeRepository?.save(Subscribe(saveUser, saveCharacter2))

        Assertions.assertThat(saveSub1?.user).isEqualTo(user)
        Assertions.assertThat(saveSub1?.character).isEqualTo(character1)
        Assertions.assertThat(saveSub2?.user).isEqualTo(user)
        Assertions.assertThat(saveSub2?.character).isEqualTo(character2)
    }

}