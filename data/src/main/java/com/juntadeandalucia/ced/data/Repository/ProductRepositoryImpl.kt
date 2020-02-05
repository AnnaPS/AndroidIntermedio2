package com.juntadeandalucia.ced.data.Repository

import com.juntadeandalucia.ced.common.Either
import com.juntadeandalucia.ced.data.Response
import com.juntadeandalucia.ced.domain.ProductEntityData
import com.juntadeandalucia.ced.domain.ErrorData
import com.juntadeandalucia.ced.domain.ProductEntityView
import com.juntadeandalucia.ced.domain.ProductRepository
import java.util.*


class ProductRepositoryImpl : ProductRepository {

    private val products: MutableList<ProductEntityView> = mutableListOf()
    private var canDelete = false

    override suspend fun deleteProduct(product: ProductEntityView): Either<ErrorData, List<ProductEntityView>> {


       products.forEach {
           if(it == product){
               products.remove(it)
               canDelete = true
           }
       }

        val response =  if(canDelete){
            Response.Suscces(true)
        }else{
            Response.Error(false)
        }

        return when (response){
            is Response.Suscces -> Either.Right(products)
            is Response.Error -> Either.Left(ErrorData("Error al borrar producto"))
        }

    }


}