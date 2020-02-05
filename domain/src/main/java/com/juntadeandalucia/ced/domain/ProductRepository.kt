package com.juntadeandalucia.ced.domain

import com.juntadeandalucia.ced.common.Either

interface ProductRepository {
   suspend fun getCategory(error: Boolean): Either<ErrorData, List<ProductEntityData>>
}