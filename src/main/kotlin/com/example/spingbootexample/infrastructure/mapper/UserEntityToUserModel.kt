package com.example.spingbootexample.infrastructure.mapper

import com.example.spingbootexample.base.IConverter
import com.example.spingbootexample.domain.model.login.UserModel
import com.example.spingbootexample.infrastructure.model.db.UsersEntity

class UserEntityToUserModel : IConverter<UsersEntity, UserModel> {
    override fun convert(input: UsersEntity): UserModel {
        val userModel = UserModel(
            id = input.id,
            username = input.username,
            password = input.password,
            email = input.email,
            fullName = input.fullName,
            bio = input.bio,
            avatarUrl = input.avatarUrl,
            createdAt = input.createdAt
        )

        return userModel
    }
}