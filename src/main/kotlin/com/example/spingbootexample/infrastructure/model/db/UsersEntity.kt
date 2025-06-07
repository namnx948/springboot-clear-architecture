package com.example.spingbootexample.infrastructure.model.db

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "users")
data class UsersEntity(
    @Id
    @Column(columnDefinition = "UUID")
    var id: UUID = UUID.randomUUID(),

    @Column(nullable = false, unique = true, length = 50)
    var username: String? = "",

    @Column(nullable = false, unique = true, length = 100)
    var email: String? = "",

    @Column(name = "password_hash", nullable = false, columnDefinition = "text")
    var password: String? = "",

    @Column(name = "full_name", nullable = false, length = 100)
    var fullName: String? = "",

    @Column(columnDefinition = "text")
    var bio: String? = "",

    @Column(name = "avatar_url", columnDefinition = "text")
    var avatarUrl: String? = "",

    @Column(name = "crrated_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()
)