package com.example.spingbootexample.application.dto.response.login

data class TokenResult (
    var accessToken: String? = null,
    var refreshToken: String? = null,
    var expiresIn: Long? = null
)