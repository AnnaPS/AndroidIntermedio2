package com.juntadeandalucia.ced.domain

import com.juntadeandalucia.ced.common.Either

interface LoginRepository {
     fun getCategory(user: UserRequest): Either<ErrorData, UserResponse>
}