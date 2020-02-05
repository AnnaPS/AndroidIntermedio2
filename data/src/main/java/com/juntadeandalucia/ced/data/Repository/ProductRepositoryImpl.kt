package com.juntadeandalucia.ced.data.Repository

import com.juntadeandalucia.ced.common.Either
import com.juntadeandalucia.ced.data.Response
import com.juntadeandalucia.ced.domain.ProductEntityData
import com.juntadeandalucia.ced.domain.ErrorData
import com.juntadeandalucia.ced.domain.ProductEntityView
import com.juntadeandalucia.ced.domain.ProductRepository
import java.util.*


class ProductRepositoryImpl : ProductRepository {

    private val products: MutableList<ProductEntityData> = mutableListOf()
    private var canDelete = false

    override suspend fun deleteProduct(product: ProductEntityData): Either<ErrorData, List<ProductEntityData>> {

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

    override suspend fun getCategory(error: Boolean): Either<ErrorData, List<ProductEntityData>> {
        var listImage : MutableList<String> = arrayListOf()
        listImage.add("")
        listImage.add("")
        listImage.add("")

        for (i in 0..3) {
            products.add(ProductEntityData(i, "Titulo $i","Subtitulo $i",listImage))        }

        val response : Response = if(error){
            Response.Suscces(error)
        }else
            Response.Error(error)

        return when(response){
            is  Response.Suscces -> Either.Right(products)
            is Response.Error -> Either.Left(ErrorData("ERROR"))
        }
    }


}