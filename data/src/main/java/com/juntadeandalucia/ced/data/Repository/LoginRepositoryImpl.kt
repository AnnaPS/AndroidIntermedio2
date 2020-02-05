package com.juntadeandalucia.ced.data.Repository

import com.juntadeandalucia.ced.common.Either
import com.juntadeandalucia.ced.data.Response
import com.juntadeandalucia.ced.domain.*



class LoginRepositoryImpl : LoginRepository {
    override fun getCategory(user: UserRequest): Either<ErrorData, UserResponse> {

        val response =  if(true){
            Response.Suscces(true)
        }else{
            Response.Error(false)
        }


        return when(response){
            is  Response.Suscces -> Either.Right(UserResponse(name = user.userName))
            is Response.Error -> Either.Left(ErrorData("ERROR"))

        }
    }


}