package com.juntadeandalucia.ced.data.Repository

import com.juntadeandalucia.ced.common.Either
import com.juntadeandalucia.ced.data.Response
import com.juntadeandalucia.ced.domain.Category
import com.juntadeandalucia.ced.domain.CategoryError
import com.juntadeandalucia.ced.domain.CategoryRepository


class CategoryRepositoryImpl : CategoryRepository {

    private val categorys: MutableList<Category> = mutableListOf()


    override suspend fun getCategory(error: Boolean): Either<CategoryError, List<Category>> {
        for (i in 0..3) {
            categorys.add(Category("Category $i"))
        }

        val response : Response = if(error){
            Response.Suscces(error)
        }else
            Response.Error(error)

        return when(response){
            is  Response.Suscces -> Either.Right(categorys)
            is Response.Error -> Either.Left(CategoryError("ERROR"))
        }

    }

}