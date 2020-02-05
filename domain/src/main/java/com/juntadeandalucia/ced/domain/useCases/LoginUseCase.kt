package com.juntadeandalucia.ced.domain.useCases

import com.juntadeandalucia.ced.common.Either
import com.juntadeandalucia.ced.domain.ErrorData
import com.juntadeandalucia.ced.domain.LoginRepository
import com.juntadeandalucia.ced.domain.UserRequest
import com.juntadeandalucia.ced.domain.UserResponse

class LoginUseCase (private val repository: LoginRepository){
    suspend fun login(user: UserRequest): Either<ErrorData, UserResponse> = repository.getCategory(user)


}