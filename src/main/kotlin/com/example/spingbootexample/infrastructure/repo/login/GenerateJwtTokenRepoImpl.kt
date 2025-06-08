package com.example.spingbootexample.infrastructure.repo.login

import com.example.spingbootexample.application.dto.response.login.TokenResult
import com.example.spingbootexample.domain.model.login.UserModel
import com.example.spingbootexample.domain.repo.login.IGenerateJwtTokenRepo
import com.example.spingbootexample.infrastructure.config.JwtService
import org.springframework.stereotype.Repository

@Repository
class GenerateJwtTokenRepoImpl(
    private val jwtService: JwtService,
) : IGenerateJwtTokenRepo {
    override fun execute(userModel: UserModel): TokenResult {
        return jwtService.generateToken(userModel.username ?: "", userModel.email ?: "")
    }
}