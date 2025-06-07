package com.example.spingbootexample.application.usecase.login

import com.example.spingbootexample.application.dto.LoginResponse
import com.example.spingbootexample.application.usecase.base.BaseUseCase
import com.example.spingbootexample.domain.mapper.TokenResultToLoginResponse
import com.example.spingbootexample.domain.model.login.UserModel
import com.example.spingbootexample.domain.repo.login.IGenerateJwtTokenRepo
import org.springframework.stereotype.Service

@Service
class GenerateJwtTokenUseCase(private val iGenerateJwtTokenRepo: IGenerateJwtTokenRepo) : BaseUseCase() {
    fun execute(loginResponse: LoginResponse, userModel: UserModel): LoginResponse {
        val tokenResult = iGenerateJwtTokenRepo.execute(userModel)
        return TokenResultToLoginResponse().convert(tokenResult, loginResponse)
    }
}