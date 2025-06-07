package com.example.spingbootexample.domain.repo.login

import com.example.spingbootexample.base.ResultData
import com.example.spingbootexample.domain.model.login.UserModel
import com.example.spingbootexample.domain.repo.base.IBaseRepo

interface ILoginRepo : IBaseRepo {
    fun loginUser(username: String, password: String): UserModel?
}