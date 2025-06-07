package com.example.spingbootexample.infrastructure.repo

import com.example.spingbootexample.domain.model.Customer
import com.example.spingbootexample.domain.repo.ICustomerRepo
import com.example.spingbootexample.infrastructure.model.db.jpa.CustomerJpa
import com.example.spingbootexample.utils.convertToCustomer
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class CustomerRepoImpl(private val customerJpa: CustomerJpa) : ICustomerRepo {
    override fun findCustomerById(id: Long): Customer? {
        val customerDb = customerJpa.findByIdOrNull(id)
        return customerDb?.convertToCustomer()
    }
}