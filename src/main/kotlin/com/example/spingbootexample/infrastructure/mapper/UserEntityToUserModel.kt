package com.example.spingbootexample.infrastructure.mapper

import com.example.spingbootexample.base.IConverter
import com.example.spingbootexample.domain.model.login.UserModel
import com.example.spingbootexample.infrastructure.model.db.UsersEntity

class UserEntityToUserModel : IConverter<UsersEntity, UserModel> {
    override fun convert(input: UsersEntity): UserModel {
        val userModel = UserModel()
        userModel.username = input.username
        userModel.email = input.email
        userModel.fullName = input.fullName
        userModel.bio = input.bio
        userModel.avatarUrl = input.avatarUrl
        userModel.createdAt = input.createdAt
        return userModel
    }
}