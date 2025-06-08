package com.example.spingbootexample.web.controller.base

import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class BaseController {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    protected fun <T> success(data: T?, message: String = "success"): ApiResponse<T> =
        ApiResponse.success(data = data)

    protected fun <T> error(
        code: Int,
        errorCode: String? = "",
        message: String? = ""
    ): ApiResponse<T> =
        ApiResponse.error(code, errorCode = errorCode, message = message ?: "")
}