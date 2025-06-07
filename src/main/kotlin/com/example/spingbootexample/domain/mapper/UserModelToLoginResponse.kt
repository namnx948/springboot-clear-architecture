package com.example.spingbootexample.domain.mapper

import com.example.spingbootexample.application.dto.LoginResponse
import com.example.spingbootexample.base.IConverter
import com.example.spingbootexample.domain.model.login.UserModel

class UserModelToLoginResponse : IConverter<UserModel, LoginResponse> {
    override fun convert(input: UserModel): LoginResponse {
        val loginResponse = LoginResponse()
        loginResponse.username = input.username
        loginResponse.email = input.email
        loginResponse.fullName = input.fullName
        loginResponse.bio = input.bio
        loginResponse.avatarUrl = input.avatarUrl
        loginResponse.createdAt = input.createdAt
        return loginResponse
    }
}