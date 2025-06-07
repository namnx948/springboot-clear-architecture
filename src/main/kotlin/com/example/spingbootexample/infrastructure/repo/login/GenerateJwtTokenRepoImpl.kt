package com.example.spingbootexample.infrastructure.repo.login

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.example.spingbootexample.domain.model.login.TokenResult
import com.example.spingbootexample.domain.model.login.UserModel
import com.example.spingbootexample.domain.repo.login.IGenerateJwtTokenRepo
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Repository
import java.time.Instant
import java.util.*

@Repository
class GenerateJwtTokenRepoImpl(
    @Value("\${auth.oauth2.jwt.secret}") private val jwtSecret: String,
    @Value("\${auth.oauth2.expiration}") private val expiration: Long,
    @Value("\${auth.oauth2.refresh-expiration}") private val accessTokenExpiration: Long,
) : IGenerateJwtTokenRepo {
    override fun execute(userModel: UserModel): TokenResult {
        val now = Instant.now()
        val algorithm = Algorithm.HMAC256("secret")
        val accessToken = JWT.create()
            .withSubject(userModel.id.toString())
            .withClaim("username", userModel.username)
            .withClaim("email", userModel.email)
            .withIssuedAt(Date.from(now))
            .withExpiresAt(Date.from(now.plusSeconds(expiration)))
            .sign(algorithm)

        val refreshToken = JWT.create()
            .withSubject(userModel.id.toString())
            .withClaim("type", "refresh_token")
            .withIssuedAt(Date.from(now))
            .withExpiresAt(Date.from(now.plusSeconds(accessTokenExpiration)))
            .sign(algorithm)

        val tokenResult = TokenResult()
        tokenResult.accessToken = accessToken
        tokenResult.refreshToken = refreshToken
        tokenResult.expiresIn = expiration

        return tokenResult
    }
}