package com.juntadeandalucia.ced.data.Repository

import com.juntadeandalucia.ced.common.Either
import com.juntadeandalucia.ced.data.Response
import com.juntadeandalucia.ced.domain.ProductEntityData
import com.juntadeandalucia.ced.domain.ErrorData
import com.juntadeandalucia.ced.domain.ProductRepository
import java.util.*


class ProductRepositoryImpl : ProductRepository {

    private var categorys: MutableList<ProductEntityData> = mutableListOf()


    override suspend fun getCategory(error: Boolean): Either<ErrorData, List<ProductEntityData>> {
        categorys = arrayListOf()
        var listImage : MutableList<String> = arrayListOf()
        listImage.add("")
        listImage.add("")
        listImage.add("")

        for (i in 0..3) {
            categorys.add(ProductEntityData(i, "Titulo $i","Subtitulo $i",listImage))        }

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