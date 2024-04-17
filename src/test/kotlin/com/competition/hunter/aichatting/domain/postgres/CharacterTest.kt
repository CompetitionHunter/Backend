package com.competition.hunter.aichatting.domain.postgres

import com.competition.hunter.aichatting.repository.postgres.CharacterRepository
import com.competition.hunter.aichatting.repository.postgres.WorkRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.text.SimpleDateFormat

@DataJpaTest
class CharacterTest {

    @Autowired
    val characterRepository: CharacterRepository? = null

    @Autowired
    val workRepository: WorkRepository? = null

    @Test
    @DisplayName("캐릭터가 DB에 잘 저장되는지 확인")
    fun saveCharacterTest() {
        var work = Work("가비지타임", "작품 사진 경로")
        var character = Character(work, "기상호", SimpleDateFormat("MM.dd").parse("1.11"), mutableListOf("허세", "귀여움"), "캐릭터 프로필 경로")

        var saveCharacter = characterRepository?.save(character)

        Assertions.assertThat(saveCharacter?.work).isEqualTo(work)
        Assertions.assertThat(saveCharacter?.name).isEqualTo(character.name)
        Assertions.assertThat(saveCharacter?.birthday).isEqualTo(character.birthday)
        Assertions.assertThat(saveCharacter?.personality).isEqualTo(character.personality)
        Assertions.assertThat(saveCharacter?.profile).isEqualTo(character.profile)
    }

    @Test
    @DisplayName("캐릭터 생성 시 Work 외래키와 링크되는지 확인")
    fun checkFKWorkTest() {
        var saveWork = workRepository?.save(Work("가비지타임", "작품 사진 경로"))
        var c1 = characterRepository?.save(Character(saveWork, "기상호", SimpleDateFormat("MM.dd").parse("1.11"), mutableListOf("허세", "귀여움"), "캐릭터 프로필 경로"))
        var c2 = characterRepository?.save(Character(saveWork, "박병찬", SimpleDateFormat("MM.dd").parse("10.1"), mutableListOf("멋있음", "강철멘탈"), "캐릭터 프로필 경로"))

        saveWork?.addCharacter(c1!!)
        saveWork?.addCharacter(c2!!)

        Assertions.assertThat(saveWork?.characters?.size).isEqualTo(2)
    }

    @Test
    @DisplayName("캐릭터 성격 변경 기능 확인")
    fun checkUpdatePersonalityTest() {
        var saveWork = workRepository?.save(Work("가비지타임", "작품 사진 경로"))
        var c = characterRepository?.save(Character(saveWork, "기상호", SimpleDateFormat("MM.dd").parse("1.11"), mutableListOf("허세", "귀여움"), "캐릭터 프로필 경로"))

        c?.updatePersonality(mutableListOf("주인공"))

        Assertions.assertThat(c?.personality).isEqualTo(mutableListOf("주인공"))
    }

}