package com.example.spingbootexample.web.controller

import com.example.spingbootexample.application.dto.LoginResponse
import com.example.spingbootexample.application.usecase.login.LoginUserUseCase
import com.example.spingbootexample.base.StatusResult
import com.example.spingbootexample.web.controller.base.ApiResponse
import com.example.spingbootexample.web.controller.base.BaseController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(private val loginUserUseCase: LoginUserUseCase) : BaseController() {

    @PostMapping("/login")
    fun login(): ApiResponse<LoginResponse> {
        val userName = "test"
        val password = "test"
        val resultData = loginUserUseCase.execute(userName, password)
        if (resultData.status == StatusResult.SUCCESS)
            return ApiResponse.success(resultData.data)
        return ApiResponse.error(100)
    }


}