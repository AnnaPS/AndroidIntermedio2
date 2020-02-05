package com.juntadeandalucia.ced.domain.di

import com.juntadeandalucia.ced.domain.useCases.DeleteProduct
import com.juntadeandalucia.ced.domain.useCases.GetProduct
import com.juntadeandalucia.ced.domain.useCases.LoginUseCase
import com.juntadeandalucia.ced.domain.useCases.ModifyProduct
import org.koin.dsl.module


class DomainKoinConfiguration {

    fun getModule() = module {
        factory { GetProduct(get()) }
        factory { DeleteProduct(get()) }
        factory { LoginUseCase(get()) }
        factory { ModifyProduct(get()) }
    }
}

