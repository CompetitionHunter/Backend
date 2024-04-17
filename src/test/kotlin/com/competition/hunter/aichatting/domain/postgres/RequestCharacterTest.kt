package com.competition.hunter.aichatting.domain.postgres

import com.competition.hunter.aichatting.domain.postgres.util.RequestStatus
import com.competition.hunter.aichatting.repository.postgres.CharacterRepository
import com.competition.hunter.aichatting.repository.postgres.RequestCharacterRepository
import com.competition.hunter.aichatting.repository.postgres.WorkRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.text.SimpleDateFormat

@DataJpaTest
class RequestCharacterTest {

    @Autowired
    val requestCharacterRepository: RequestCharacterRepository? = null

    @Autowired
    val characterRepository: CharacterRepository? = null

    @Autowired
    val workRepository: WorkRepository? = null

    @Test
    @DisplayName("requestCharacter가 DB에 잘 저장되는지 확인")
    fun saveRequestCharacterTest() {
        var requestCharacter = RequestCharacter("test@test.com", "가비지타임", "박병찬")

        var save = requestCharacterRepository?.save(requestCharacter)

        Assertions.assertThat(save).isEqualTo(requestCharacter)
    }

    @Test
    @DisplayName("캐릭터 생성 이후 FK 적용 확인")
    fun linkFKCharacterTest() {
        var requestCharacter = RequestCharacter("test@test.com", "가비지타임", "박병찬")
        var work = Work("가비지타임", "작품 사진 경로")
        var character = Character(work, "기상호", SimpleDateFormat("MM.dd").parse("1.11"), mutableListOf("허세", "귀여움"), "캐릭터 프로필 경로")

        var saveRequest = requestCharacterRepository?.save(requestCharacter)
        var saveWork = workRepository?.save(work)
        var saveCharacter = characterRepository?.save(character)
        requestCharacter.createCharacter(saveCharacter!!)

        Assertions.assertThat(requestCharacter?.character?.id).isEqualTo(1)
    }

}