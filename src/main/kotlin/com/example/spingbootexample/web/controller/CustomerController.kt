package com.example.spingbootexample.web.controller

import com.example.spingbootexample.application.dto.CustomerResponse
import com.example.spingbootexample.application.usecase.GetCustomerUseCase
import com.example.spingbootexample.web.controller.base.ApiResponse
import com.example.spingbootexample.web.controller.base.BaseController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerController(private val getCustomerUseCase: GetCustomerUseCase) : BaseController() {

    @GetMapping("/{id}")
    fun getCustomer(id: Long): ApiResponse<CustomerResponse?> {
        return success(getCustomerUseCase.execute(id))
    }
}