package com.juntadeandalucia.ced.domain.useCases

import com.juntadeandalucia.ced.common.Either
import com.juntadeandalucia.ced.domain.ErrorData
import com.juntadeandalucia.ced.domain.ProductEntityData
import com.juntadeandalucia.ced.domain.ProductEntityView
import com.juntadeandalucia.ced.domain.ProductRepository

class DeleteProduct(private val repository: ProductRepository) {

    suspend fun deleteProduct(product: ProductEntityView) : Either<ErrorData, MutableList<ProductEntityView>> {
        var response = repository.deleteProduct(mapperToData(product))
        when(response){
            is Either.Left ->{
                return response
            }
            is Either.Right ->{
                return Either.Right(productMapper(response.r))
            }
        }
    }


    companion object{
         fun mapperToData(response: ProductEntityView) =  ProductEntityData (
            1,
             response.title,
             response.subtitle,
             response.imageList.toMutableList()
         )
    }

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