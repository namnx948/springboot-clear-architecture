package com.example.spingbootexample.application.usecase.login

import com.example.spingbootexample.application.dto.request.login.RefreshTokenRequest
import com.example.spingbootexample.application.dto.response.login.TokenResult
import com.example.spingbootexample.base.ResultData
import com.example.spingbootexample.domain.repo.login.IRefreshTokenRepo

class RefreshTokenUseCase(
    private val refreshTokenRepo: IRefreshTokenRepo,
) {
    fun execute(refreshTokenRequest: RefreshTokenRequest): ResultData<TokenResult> {

        if (refreshTokenRequest.refreshToken.isNullOrEmpty()) {
            return ResultData.failure()
        }

        val result = refreshTokenRepo.execute(refreshTokenRequest.refreshToken!!)
        if (result == null)
            return ResultData.failure()

        return ResultData.success(result)
    }
}