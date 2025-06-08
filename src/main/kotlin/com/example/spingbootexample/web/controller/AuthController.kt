package com.example.spingbootexample.web.controller

import com.example.spingbootexample.application.dto.response.login.LoginResponse
import com.example.spingbootexample.application.usecase.login.LoginUserUseCase
import com.example.spingbootexample.base.StatusResult
import com.example.spingbootexample.web.controller.base.ApiResponse
import com.example.spingbootexample.web.controller.base.BaseController
import com.example.spingbootexample.web.controller.base.ErrorCode
import com.example.spingbootexample.web.controller.base.ErrorCodeServer
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(private val loginUserUseCase: LoginUserUseCase) : BaseController() {

    @PostMapping("/public/login")
    fun login(): ApiResponse<LoginResponse> {
        val userName = "testuser"
        val password = "123456"
        val resultData = loginUserUseCase.execute(userName, password)
        if (resultData.status == StatusResult.SUCCESS)
            return success(data = resultData.data)
        return error(code = ErrorCodeServer.FAIL_LOGIN, errorCode = ErrorCode.NOT_FOUND_USER)
    }

    @PostMapping("/auth/change-password")
    fun changePassword(): ApiResponse<String> {
        return success("TestThoine")
    }

    @PostMapping("/auth/refresh-tokens")
    fun refreshTokens(): ApiResponse<String> {

    }


}