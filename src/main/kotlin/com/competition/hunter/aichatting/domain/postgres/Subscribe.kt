package com.competition.hunter.aichatting.domain.postgres;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.jdo.annotations.Join

@Data
@Entity
@Table(name = "subscribe")
class Subscribe (

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id")
    val character: Character? = null

) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subscribe_id")
    val id: Long? = null

    val start: String? = LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"))
}
