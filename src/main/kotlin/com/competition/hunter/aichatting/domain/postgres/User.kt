package com.competition.hunter.aichatting.domain.postgres;

import jakarta.persistence.*;
import lombok.Data;
import java.util.*


@Data
@Entity
@Table(name = "user")
class User (

    val email: String,

    pw: String,

    nickname: String,

    birthday: Date

) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    val id: Long? = null

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.PERSIST))
    var subscribes: MutableList<Subscribe>? = mutableListOf()
        private set

    var pw: String = pw
        private set
    var nickname: String = nickname
        private set
    var birthday: Date = birthday
        private set
    var suspended: Boolean = false
        private set

    fun updatePassword(pw: String) {
        this.pw = pw
    }

    fun updateNickname(nickname: String) {
        this.nickname = nickname
    }

    fun updateBirthday(birthday: Date) {
        this.birthday = birthday
    }

    fun addSubscribe(subscribe: Subscribe) {
        this.subscribes?.add(subscribe)
    }

}