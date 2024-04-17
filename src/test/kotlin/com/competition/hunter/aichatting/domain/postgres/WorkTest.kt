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
class WorkTest {

    @Autowired
    val workRepository: WorkRepository? = null

    @Test
    @DisplayName("Work가 DB에 잘 저장되는지 확인")
    fun saveWorkTest() {
        var work = Work("가비지타임", "작품 사진 경로")

        var saveWork = workRepository?.save(work)

        Assertions.assertThat(saveWork?.id).isEqualTo(1)
        Assertions.assertThat(saveWork?.title).isEqualTo(work.title)
        Assertions.assertThat(saveWork?.profile).isEqualTo(work.profile)
    }

}