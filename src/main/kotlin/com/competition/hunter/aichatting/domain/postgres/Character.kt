package com.competition.hunter.aichatting.domain.postgres;

import com.competition.hunter.aichatting.dto.CharacterDto
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.*

@Data
@Entity
@Table(name = "character")
class Character(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_id")
    val work: Work? = null,

    val name: String,

    @DateTimeFormat(pattern = "MM.dd")
    val birthday: Date,

    personality: MutableList<String>,

    val profile: String

) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "character_id")
    val id: Long? = null

    var personality: MutableList<String> = personality
        private set

    @OneToMany(mappedBy = "character", fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.PERSIST))
    var subscribes: MutableList<Subscribe>? = mutableListOf()
        private set

    fun updatePersonality(personality: MutableList<String>) {
        this.personality = personality
    }

    fun addSubscribe(subscribe: Subscribe) {
        this.subscribes?.add(subscribe)
    }

    fun toCharacterDto(): CharacterDto{
        return CharacterDto(
            this.id!!,
            this.name,
            this.profile,
            this.work?.title
        )
    }

}
