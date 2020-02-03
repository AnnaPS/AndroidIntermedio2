package com.juntadeandalucia.ced.domain.di

import com.juntadeandalucia.ced.domain.useCases.GetCategory
import org.koin.dsl.module


class DomainKoinConfiguration {

    fun getModule() = module {
        factory { GetCategory(get()) }

    }
}

