package com.zbistapp.translator

import android.app.Application
import com.zbistapp.translator.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(retrofitModule, repoModule, viewModelModule, roomModule))
        }
    }
}