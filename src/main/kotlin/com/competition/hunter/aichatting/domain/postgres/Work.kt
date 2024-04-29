package com.competition.hunter.aichatting.domain.postgres;

import com.competition.hunter.aichatting.dto.WorkDto
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "work")
class Work (

    val title: String,

    val profile: String

) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_id")
    val id: Long? = null

    @OneToMany(mappedBy = "work", fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.PERSIST))
    var characters: MutableList<Character> = mutableListOf()
        private set

    fun addCharacter(character: Character) {
        this.characters?.add(character)
    }

    fun toWorkDto(): WorkDto {
        return WorkDto(
            this.title,
            this.profile,
            this.characters.map { it.toCharacterDto() }
        )
    }
}
