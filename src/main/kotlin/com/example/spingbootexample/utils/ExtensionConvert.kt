package com.example.spingbootexample.utils

import com.example.spingbootexample.application.dto.CustomerResponse
import com.example.spingbootexample.base.ResultData
import com.example.spingbootexample.domain.model.Customer
import com.example.spingbootexample.infrastructure.model.db.CustomerDB

fun CustomerDB.convertToCustomer() = Customer(id = this.id, name = this.name, email = this.email)
fun Customer.convertToCustomerResponse() = CustomerResponse(id = this.id, name = this.name, email = this.email)
