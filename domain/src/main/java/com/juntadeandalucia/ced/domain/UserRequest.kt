package com.juntadeandalucia.ced.domain

import java.io.Serializable

class UserRequest (
    val userName : String,
    var password: String
): Serializable