package com.example.spingbootexample.infrastructure.repo.login

import com.example.spingbootexample.application.dto.response.login.TokenResult
import com.example.spingbootexample.domain.repo.login.IRefreshTokenRepo
import com.example.spingbootexample.infrastructure.config.JwtService
import org.springframework.stereotype.Repository

@Repository
class RefreshTokenRepoImpl(private val jwtService: JwtService) : IRefreshTokenRepo {
    override fun execute(refreshToken: String): TokenResult? {
        if (!jwtService.validateToken(refreshToken)) {
            return null
        }

        val username = jwtService.getUsername(refreshToken)
        val email = jwtService.getClaim(token = refreshToken, key = "email")

        return jwtService.generateToken(username, email)
    }
}