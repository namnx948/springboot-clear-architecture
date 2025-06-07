package com.example.spingbootexample.infrastructure.model.db.jpa

import com.example.spingbootexample.infrastructure.model.db.CustomerDB
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerJpa : JpaRepository<CustomerDB, Long> {
}