package com.example.spingbootexample.application.usecase.login

import com.example.spingbootexample.application.dto.response.login.LoginResponse
import com.example.spingbootexample.base.ResultData
import com.example.spingbootexample.domain.mapper.UserModelToLoginResponse
import com.example.spingbootexample.domain.repo.login.IGenerateJwtTokenRepo
import com.example.spingbootexample.domain.repo.login.ILoginRepo
import com.example.spingbootexample.web.controller.base.ErrorCode
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class LoginUserUseCase(
    private val iLoginRepo: ILoginRepo,
    private val tokenRepo: IGenerateJwtTokenRepo,
    private val passwordEncoder: PasswordEncoder
) {
    fun execute(username: String, password: String): ResultData<LoginResponse> {
        val userModel = iLoginRepo.loginUser(username)

        if (userModel == null) {
            return ResultData.failure(errorCode = ErrorCode.NOT_FOUND_USER)
        }

        if (passwordEncoder.matches(password, userModel.password)) {
            return ResultData.failure(errorCode = ErrorCode.INVALID_PASSWORD)
        }

        val loginResponse = UserModelToLoginResponse().convert(userModel)
        val tokenResult = GenerateJwtTokenUseCase(tokenRepo).execute(loginResponse, userModel)
        loginResponse.accessToken = tokenResult.accessToken
        loginResponse.refreshToken = tokenResult.refreshToken
        loginResponse.expiresIn = tokenResult.expiresIn

        return ResultData.success(loginResponse)
    }
}