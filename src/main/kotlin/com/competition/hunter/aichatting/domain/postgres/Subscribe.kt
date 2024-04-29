package com.competition.hunter.aichatting.domain.postgres;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Data
@Entity
@Table(name = "subscribe")
class Subscribe (

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val member: Member? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id")
    val character: Character? = null

) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscribe_id")
    val id: Long? = null

    val start: String? = LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"))
}
