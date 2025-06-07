package com.example.spingbootexample.domain.mapper

import com.example.spingbootexample.application.dto.LoginResponse
import com.example.spingbootexample.base.ITripperConverter
import com.example.spingbootexample.domain.model.login.TokenResult

class TokenResultToLoginResponse : ITripperConverter<TokenResult, LoginResponse, LoginResponse> {
    override fun convert(
        input: TokenResult,
        source: LoginResponse
    ): LoginResponse {
        source.refreshToken = input.refreshToken
        source.expiresIn = input.expiresIn
        source.accessToken = input.accessToken
        return source
    }
}