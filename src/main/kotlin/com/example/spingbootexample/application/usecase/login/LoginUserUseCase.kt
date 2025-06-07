package com.example.spingbootexample.application.usecase.login

import com.example.spingbootexample.application.dto.LoginResponse
import com.example.spingbootexample.base.ResultData
import com.example.spingbootexample.domain.mapper.TokenResultToLoginResponse
import com.example.spingbootexample.domain.mapper.UserModelToLoginResponse
import com.example.spingbootexample.domain.repo.login.IGenerateJwtTokenRepo
import com.example.spingbootexample.domain.repo.login.ILoginRepo
import org.springframework.stereotype.Service

@Service
class LoginUserUseCase(
    private val iLoginRepo: ILoginRepo,
    private val tokenRepo: IGenerateJwtTokenRepo
) {
    fun execute(username: String, password: String): ResultData<LoginResponse> {
        val userModel = iLoginRepo.loginUser(username, password)
        if (userModel == null) {
            return ResultData.failure()
        }
        val loginResponse = UserModelToLoginResponse().convert(userModel)
        GenerateJwtTokenUseCase(tokenRepo).execute(loginResponse, userModel)
        return ResultData.success(loginResponse)
    }
}