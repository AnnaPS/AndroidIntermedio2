package com.everis.androidintermedio2.domain

import com.everis.androidintermedio2.data.CategoryRepository
import com.everis.androidintermedio2.model.Category

class GetCategory (private val repository: CategoryRepository){

    operator fun invoke(): List<Category> = repository.getCategory()
}