package com.juntadeandalucia.ced.domain

import com.juntadeandalucia.ced.common.Either

interface ProductRepository {
   suspend fun deleteProduct(product: ProductEntityData): Either<ErrorData, List<ProductEntityData>>
   suspend fun getCategory(error: Boolean): Either<ErrorData, List<ProductEntityData>>

}