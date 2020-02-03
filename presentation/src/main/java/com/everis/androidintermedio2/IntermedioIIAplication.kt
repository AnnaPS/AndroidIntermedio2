package com.everis.androidintermedio2

import android.app.Application
import com.everis.androidintermedio2.di.PresentationKoinConfiguration
import com.juntadeandalucia.ced.data.di.DataKoinConfiguration
import com.juntadeandalucia.ced.domain.di.DomainKoinConfiguration
import org.koin.core.context.startKoin

class IntermedioIIAplication :  Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    DataKoinConfiguration().getModule(),
                    DomainKoinConfiguration().getModule(),
                    PresentationKoinConfiguration().getModule()
                )
            )
        }
    }
}