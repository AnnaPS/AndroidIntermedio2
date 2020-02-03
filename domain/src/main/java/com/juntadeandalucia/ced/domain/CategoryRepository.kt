package com.juntadeandalucia.ced.domain

import com.juntadeandalucia.ced.common.Either

interface CategoryRepository {
   suspend fun getCategory(error: Boolean): Either<CategoryError, List<Category>>
}