package com.example.spingbootexample.application.dto

import java.time.LocalDateTime

data class LoginResponse(
    var accessToken: String? = null,
    var refreshToken: String? = null,
    var expiresIn: Long? = null,
    var username: String? = null,
    var email: String? = null,
    var fullName: String? = null,
    var bio: String? = null,
    var avatarUrl: String? = null,
    var createdAt: LocalDateTime? = null
)