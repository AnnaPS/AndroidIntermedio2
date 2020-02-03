package com.juntadeandalucia.ced.domain

interface CategoryRepository {
   suspend fun getCategory(): List<Category>
}