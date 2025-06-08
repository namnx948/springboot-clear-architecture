package com.example.spingbootexample.domain.repo.login

import com.example.spingbootexample.base.ResultData
import com.example.spingbootexample.application.dto.response.login.TokenResult
import com.example.spingbootexample.domain.model.login.UserModel

interface IGenerateJwtTokenRepo {
    fun execute(userModel: UserModel): TokenResult
}