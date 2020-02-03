package com.juntadeandalucia.ced.data.Repository

import com.juntadeandalucia.ced.domain.Category
import com.juntadeandalucia.ced.domain.CategoryRepository


class CategoryRepositoryImpl : CategoryRepository {

    private val categorys: MutableList<Category> = mutableListOf()


    override suspend fun getCategory(): List<Category> {
        for (i in 0..3) {
            categorys.add(Category("Category $i"))
        }

        return categorys
    }

}