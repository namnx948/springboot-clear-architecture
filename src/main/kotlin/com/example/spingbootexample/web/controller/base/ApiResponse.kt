package com.example.spingbootexample.web.controller.base

data class ApiResponse<T>(
    var code: Int,
    var message: String,
    var data: T? = null
) {
    companion object {
        fun <T> success(data: T?): ApiResponse<T> {
            return ApiResponse(200, "success", data)
        }

        fun <T> error(code: Int, message: String = ""): ApiResponse<T> {
            return ApiResponse(code, message, null)
        }
    }
}