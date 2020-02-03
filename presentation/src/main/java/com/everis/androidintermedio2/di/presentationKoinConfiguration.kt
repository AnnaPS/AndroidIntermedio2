package com.everis.androidintermedio2.di

import com.everis.androidintermedio2.view.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class PresentationKoinConfiguration {

    fun getModule() =  module{

        viewModel { MainViewModel(get()) }
    }

}