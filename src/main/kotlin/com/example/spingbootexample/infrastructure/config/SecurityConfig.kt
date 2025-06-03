package com.example.spingbootexample.infrastructure.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(private val jwtFilter: JwtAuthenticationFilter) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf {
            it.disable()
        }.sessionManagement { session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authorizeHttpRequests { auth ->
                auth.requestMatchers("/api/public/**").permitAll()
                    .requestMatchers("/api/auth/**").authenticated()
                    .anyRequest().authenticated()
            }.addFilterBefore(
                jwtFilter,
                UsernamePasswordAuthenticationFilter::class.java
            )

        return http.build()
    }
}