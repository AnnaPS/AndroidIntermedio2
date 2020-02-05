package com.juntadeandalucia.ced.domain.useCases

import com.juntadeandalucia.ced.domain.ProductEntityData
import com.juntadeandalucia.ced.domain.ProductEntityView
import com.juntadeandalucia.ced.domain.ProductRepository

class DeleteProduct(private val repository: ProductRepository) {

//    suspend fun deleteProduct(product: ProductEntityView) = repository.deleteProduct(product)


    private fun productMapper(response: List<ProductEntityData>):MutableList<ProductEntityView>{
        var entity : MutableList<ProductEntityView> = arrayListOf()

        response.forEach {
            entity.add(
                ProductEntityView(it.title,it.subtitle,it.imageList)
            )
        }
        return entity
    }
}