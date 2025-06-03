package com.example.spingbootexample.infrastructure.model.db

import org.springframework.data.jpa.repository.JpaRepository

interface CustomerJpa : JpaRepository<CustomerDB, Long> {
}
