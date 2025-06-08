package com.example.spingbootexample.infrastructure.model.db.jpa

import com.example.spingbootexample.domain.model.login.UserModel
import com.example.spingbootexample.infrastructure.model.db.UsersEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UsersJpa : JpaRepository<UsersEntity, UUID> {

    fun findByUsernameAndPassword(username: String, password: String): UsersEntity?

    fun findByUsername(username: String): UsersEntity?

}