package com.juntadeandalucia.ced.data.Repository

import com.juntadeandalucia.ced.common.Either
import com.juntadeandalucia.ced.data.Response
import com.juntadeandalucia.ced.domain.ProductEntityData
import com.juntadeandalucia.ced.domain.ErrorData
import com.juntadeandalucia.ced.domain.ProductRepository


class ProductRepositoryImpl : ProductRepository {

    private val categorys: MutableList<ProductEntityData> = mutableListOf()


    override suspend fun getCategory(error: Boolean): Either<ErrorData, List<ProductEntityData>> {
        for (i in 0..3) {
            categorys.add(ProductEntityData("Category $i", "", emptyList()))
        }

        val response : Response = if(error){
            Response.Suscces(error)
        }else
            Response.Error(error)

        return when(response){
            is  Response.Suscces -> Either.Right(categorys)
            is Response.Error -> Either.Left(ErrorData("ERROR"))
        }

    }

}