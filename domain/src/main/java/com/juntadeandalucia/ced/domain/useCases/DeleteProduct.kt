package com.juntadeandalucia.ced.domain.useCases

import com.juntadeandalucia.ced.domain.ProductEntityView
import com.juntadeandalucia.ced.domain.ProductRepository

class DeleteProduct(private val repository: ProductRepository) {

    suspend fun deleteProduct(product: ProductEntityView) = repository.deleteProduct(product)
}