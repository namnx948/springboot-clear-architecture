package com.example.spingbootexample.domain.model.login

class TokenResult {
    var accessToken: String? = null
    var refreshToken: String? = null
    var expiresIn: Long? = null
}