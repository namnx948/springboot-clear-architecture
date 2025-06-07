package com.example.spingbootexample.domain.model.login

import java.time.LocalDateTime
import java.util.UUID

class UserModel {
    var id: UUID? = null
    var username: String? = null
    var email: String? = null
    var fullName: String? = null
    var bio: String? = null
    var avatarUrl: String? = null
    var createdAt: LocalDateTime? = null
}