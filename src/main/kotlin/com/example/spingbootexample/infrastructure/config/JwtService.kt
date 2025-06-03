package com.example.spingbootexample.infrastructure.config

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.Date
import javax.crypto.SecretKey

@Service
class JwtService {
    private val secretKey: SecretKey =
        Keys.hmacShaKeyFor("your-super-secret-key-12345678901234567890123456789012".toByteArray())
    private val expirationTime = 3600000 // 1 hour

    fun generateToken(username: String): String {
        val now = Date()
        val expiration = Date(now.time + expirationTime)
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(now)
            .setExpiration(expiration)
            .signWith(secretKey)
            .compact()
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