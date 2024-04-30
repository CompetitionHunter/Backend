package com.competition.hunter.aichatting.domain.postgres;

import jakarta.persistence.*;
import lombok.Data
import org.jetbrains.annotations.NotNull
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*


@Entity
@Table(name = "member")
class Member(

    @Column
    @NotNull
    val email: String,

    pw: String,

    nickname: String,

    birthday: Date

): UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    val id: Long? = null

    @Column
    @NotNull
    var pw: String = pw
        private set
    @Column
    @NotNull
    var nickname: String = nickname
        private set
    @Column
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var birthday: Date = birthday
        private set
    @Column
    @NotNull
    var suspended: Boolean = false
        private set
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.PERSIST))
    var subscribes: MutableList<Subscribe>? = mutableListOf()
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

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
        return null
    }
    override fun getPassword(): String {
        return pw
    }
    override fun getUsername(): String {
        return username
    }
    override fun isAccountNonExpired(): Boolean {
        return true
    }
    override fun isAccountNonLocked(): Boolean {
        return true
    }
    override fun isCredentialsNonExpired(): Boolean {
        return true
    }
    override fun isEnabled(): Boolean {
        return true
    }
}