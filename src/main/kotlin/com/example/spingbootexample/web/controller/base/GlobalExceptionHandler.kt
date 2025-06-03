package com.example.spingbootexample.web.controller.base

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception): ApiResponse<Nothing> {
        return ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.message ?: "Internal Server Error")
    }

    /**
     * Thêm các exception cụ thể khác nếu bạn cần thêm
     */
}