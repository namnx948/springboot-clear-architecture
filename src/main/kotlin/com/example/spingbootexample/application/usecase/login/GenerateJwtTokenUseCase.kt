package com.example.spingbootexample.application.usecase.login

import com.example.spingbootexample.application.dto.response.login.LoginResponse
import com.example.spingbootexample.application.dto.response.login.TokenResult
import com.example.spingbootexample.application.usecase.base.BaseUseCase
import com.example.spingbootexample.domain.model.login.UserModel
import com.example.spingbootexample.domain.repo.login.IGenerateJwtTokenRepo
import org.springframework.stereotype.Service

@Service
class GenerateJwtTokenUseCase(private val iGenerateJwtTokenRepo: IGenerateJwtTokenRepo) : BaseUseCase() {
    fun execute(loginResponse: LoginResponse, userModel: UserModel): TokenResult {
        val tokenResult = iGenerateJwtTokenRepo.execute(userModel)
        return tokenResult
    }
}