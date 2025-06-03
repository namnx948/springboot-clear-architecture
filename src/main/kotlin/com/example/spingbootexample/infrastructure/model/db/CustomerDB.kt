package com.example.spingbootexample.infrastructure.model.db

import jakarta.persistence.*

@Entity
@Table(name = "customer")
data class CustomerDB(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,

    var name: String? = "",

    var email: String? = ""

)