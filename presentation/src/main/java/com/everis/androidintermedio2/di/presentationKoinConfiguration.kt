package com.everis.androidintermedio2.di

import com.everis.androidintermedio2.view.MainViewModel
import com.everis.androidintermedio2.view.login.LoginViewModel
import com.everis.androidintermedio2.view.products.ProducViewModel
import com.everis.androidintermedio2.view.products.ProductListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class PresentationKoinConfiguration {

    fun getModule() =  module{

        viewModel { MainViewModel(get()) }
        viewModel { LoginViewModel(get()) }
        viewModel { ProductListViewModel(get()) }
        viewModel { ProducViewModel(get()) }
    }

}