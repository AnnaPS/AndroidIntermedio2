package com.juntadeandalucia.ced.domain.useCases


import com.juntadeandalucia.ced.common.Either
import com.juntadeandalucia.ced.domain.Category
import com.juntadeandalucia.ced.domain.CategoryError
import com.juntadeandalucia.ced.domain.CategoryRepository

class GetCategory(private val repository: CategoryRepository) {

  suspend fun  invoke(error: Boolean): Either<CategoryError, List<Category>> = repository.getCategory(error)
}