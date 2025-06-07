package com.example.spingbootexample.infrastructure.repo.login

import com.example.spingbootexample.base.ResultData
import com.example.spingbootexample.domain.model.login.UserModel
import com.example.spingbootexample.domain.repo.login.ILoginRepo
import com.example.spingbootexample.infrastructure.mapper.UserEntityToUserModel
import com.example.spingbootexample.infrastructure.model.db.jpa.UsersJpa
import org.springframework.stereotype.Repository

@Repository
class LoginRepoImpl(private val usersJpa: UsersJpa) : ILoginRepo {
    override fun loginUser(
        username: String,
        password: String
    ): UserModel? {
        val userEntity = usersJpa.findByUsernameAndPassword(username, password)
        if (userEntity == null) {
            return null
        }

        return UserEntityToUserModel().convert(userEntity)
    }
}