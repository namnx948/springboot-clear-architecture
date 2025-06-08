package com.example.spingbootexample.domain.repo.login

import com.example.spingbootexample.application.dto.response.login.TokenResult
import com.example.spingbootexample.domain.repo.base.IBaseRepo

interface IRefreshTokenRepo : IBaseRepo {
    fun execute(refreshToken: String): TokenResult?
}