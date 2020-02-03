package com.juntadeandalucia.ced.domain.useCases


import com.juntadeandalucia.ced.domain.Category
import com.juntadeandalucia.ced.domain.CategoryRepository

class GetCategory(private val repository: CategoryRepository) {

  suspend fun  invoke(): List<Category> = repository.getCategory()
}