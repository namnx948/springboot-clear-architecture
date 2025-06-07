package com.example.spingbootexample.base

data class ResultData<T>(
    var status: StatusResult = StatusResult.FAIL,
    var data: T? = null,
    var message: String? = null
) {
    companion object {
        fun <T> success(data: T): ResultData<T> {
            return ResultData(StatusResult.SUCCESS, data)
        }

        fun <T> failure(exception: String? = ""): ResultData<T> {
            return ResultData(status = StatusResult.FAIL, message = exception)
        }
    }
}