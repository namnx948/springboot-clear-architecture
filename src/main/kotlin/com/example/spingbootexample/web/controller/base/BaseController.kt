package com.example.spingbootexample.web.controller.base

import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class BaseController {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    protected fun <T> success(data: T?, message: String = "success"): ApiResponse<T> =
        ApiResponse.success(data = data)

    protected fun error(code: Int, message: String): ApiResponse<Nothing> = ApiResponse.error(code, message)
}