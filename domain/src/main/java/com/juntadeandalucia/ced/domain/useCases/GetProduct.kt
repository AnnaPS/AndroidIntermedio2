package com.juntadeandalucia.ced.domain.useCases


import com.juntadeandalucia.ced.common.Either
import com.juntadeandalucia.ced.domain.ProductEntityData
import com.juntadeandalucia.ced.domain.ErrorData
import com.juntadeandalucia.ced.domain.ProductRepository

class GetProduct(private val repository: ProductRepository) {

  suspend fun  invoke(error: Boolean): Either<ErrorData, List<ProductEntityData>> = repository.getCategory(error)
}