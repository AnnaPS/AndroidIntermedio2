package com.juntadeandalucia.ced.domain

import com.juntadeandalucia.ced.common.Either

interface ProductRepository {
   suspend fun deleteProduct(product: ProductEntityView): Either<ErrorData, List<ProductEntityView>>
}