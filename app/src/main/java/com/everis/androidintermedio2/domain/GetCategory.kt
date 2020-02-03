package com.everis.androidintermedio2.domain

import com.juntadeandalucia.ced.data.Repository.CategoryRepository
import com.everis.androidintermedio2.model.Category

class GetCategory(private val repository: com.juntadeandalucia.ced.data.Repository.CategoryRepository) {

    suspend operator fun invoke(): List<Category> = repository.getCategory()
}