package com.zbistapp.translator

import android.app.Application
import com.zbistapp.translator.di.*
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(retrofitModule, networkModule, viewModelModule))
        }
    }
}