package com.example.spingbootexample.domain.repo

import com.example.spingbootexample.domain.model.Customer

interface ICustomerRepo {
    fun findCustomerById(id: Long): Customer?
}