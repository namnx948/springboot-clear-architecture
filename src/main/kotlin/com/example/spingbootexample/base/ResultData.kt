package com.example.spingbootexample.base

data class ResultData<T>(
    var status: StatusResult = StatusResult.FAIL,
    var data: T? = null,
    var message: String? = null,
    var errorCode: String? = null
) {
    companion object {
        fun <T> success(data: T): ResultData<T> {
            return ResultData(StatusResult.SUCCESS, data)
        }

        fun <T> failure(errorCode: String? = "", exception: String? = ""): ResultData<T> {
            return ResultData(status = StatusResult.FAIL, errorCode = errorCode, message = exception)
        }
    }
}