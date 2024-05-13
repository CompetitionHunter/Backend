package com.competition.hunter.aichatting.domain.postgres;

import com.competition.hunter.aichatting.domain.util.RequestStatus
import com.competition.hunter.aichatting.dto.RequestCharacterDto
import jakarta.persistence.*;
import lombok.Data;
import javax.jdo.annotations.Join

@Data
@Entity
@Table(name = "request_character")
class RequestCharacter (

    val member: String,

    @Column(name = "work_title")
    val workTitle: String,

    @Column(name = "character_name")
    val characterName: String,

) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_character_id")
    val id: Long? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "request_status")
    var requestStatus: RequestStatus = RequestStatus.REQUEST
        private set

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id")
    var character: Character? = null
        private set

    fun createCharacter(character: Character) {
        this.character = character
    }

    fun rejectRequest() {
        this.requestStatus = RequestStatus.REJECT
    }

    fun approveRequest() {
        this.requestStatus = RequestStatus.APPROVE
    }

    fun toRequestCharacterDto(): RequestCharacterDto {
        return RequestCharacterDto(
            this.id!!,
            this.workTitle,
            this.characterName
        )
    }

}
