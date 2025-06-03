package com.example.spingbootexample.application.usecase

import com.example.spingbootexample.application.dto.CustomerResponse
import com.example.spingbootexample.domain.repo.ICustomerRepo
import com.example.spingbootexample.utils.convertToCustomerResponse
import org.springframework.stereotype.Service

@Service
class GetCustomerUseCase(private val customerRepo: ICustomerRepo) {
    fun execute(id: Long): CustomerResponse? {
        val customer = customerRepo.findCustomerById(id)
        return customer?.convertToCustomerResponse()
    }
}