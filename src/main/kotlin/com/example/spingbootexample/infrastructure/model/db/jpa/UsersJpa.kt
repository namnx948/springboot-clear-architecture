package com.example.spingbootexample.infrastructure.model.db.jpa

import com.example.spingbootexample.infrastructure.model.db.UsersEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersJpa : JpaRepository<UsersEntity, Long> {

    fun findByUsernameAndPassword(username: String, password: String): UsersEntity?

}