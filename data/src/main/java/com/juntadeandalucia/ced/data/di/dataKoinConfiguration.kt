package com.juntadeandalucia.ced.data.di

import com.juntadeandalucia.ced.data.Repository.ProductRepositoryImpl
import com.juntadeandalucia.ced.domain.ProductRepository
import org.koin.dsl.module


class DataKoinConfiguration {

    fun getModule() = module {
        single<ProductRepository> { ProductRepositoryImpl() }

    }
}


