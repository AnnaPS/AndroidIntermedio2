package com.juntadeandalucia.ced.data

sealed class Response {
    data class Suscces(val suscces : Boolean) :Response()
    data class  Error(val error: Boolean): Response()
}