package com.juntadeandalucia.ced.data.di

import com.juntadeandalucia.ced.data.Repository.CategoryRepositoryImpl
import com.juntadeandalucia.ced.domain.CategoryRepository
import org.koin.dsl.module


class DataKoinConfiguration {

    fun getModule() = module {
        single<CategoryRepository> { CategoryRepositoryImpl() }

    }
}


