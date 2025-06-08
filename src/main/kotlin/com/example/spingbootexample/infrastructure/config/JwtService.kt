package com.example.spingbootexample.infrastructure.config

import com.example.spingbootexample.application.dto.response.login.TokenResult
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.*
import javax.crypto.SecretKey
import kotlin.math.exp

@Service
class JwtService(
    @Value("\${auth.oauth2.jwt.secret}") secretKey: String,
    @Value("\${auth.oauth2.expiration}") private val accessExpirationMs: Long,
    @Value("\${auth.oauth2.refresh-expiration}") private val refreshExpirationMs: Long
) {
    private val secretKey: SecretKey =
        Keys.hmacShaKeyFor(secretKey.toByteArray())

    fun generateToken(username: String, email: String): TokenResult {
        val now = Date()
        val accessToken = Jwts.builder()
            .setSubject(username)
            .claim("email", email)
            .setIssuedAt(now)
            .setExpiration(Date(now.time + accessExpirationMs))
            .signWith(secretKey)
            .compact()

        val refreshToken = Jwts.builder()
            .setSubject(username)
            .claim("email", email)
            .claim("type", "refresh_token")
            .setIssuedAt(now)
            .setExpiration(Date(now.time + refreshExpirationMs))
            .signWith(secretKey)
            .compact()

        return TokenResult(
            accessToken = accessToken,
            refreshToken = refreshToken,
            expiresIn = accessExpirationMs / 1000
        )

    }

    fun validateToken(token: String): Boolean {
        return try {
            val claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .body
            !claims.expiration.before(Date())
        } catch (e: Exception) {
            false
        }
    }

    fun getUsername(token: String): String {
        return Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .body
            .subject
    }

    fun getClaim(token: String, key: String): String {
        return Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .body[key].toString()
    }

    fun getUserDetail(token: String): UserDetails {
        val userName = getUsername(token)
        val authorities = listOf<SimpleGrantedAuthority>()
        return User.builder()
            .username(userName)
            .password("")
            .authorities(authorities)
            .accountExpired(false)
            .accountLocked(false)
            .credentialsExpired(false)
            .disabled(false)
            .build()
    }

}