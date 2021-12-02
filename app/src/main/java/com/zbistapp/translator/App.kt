package com.zbistapp.translator

import android.app.Application
import com.zbistapp.translator.data.TranslatorApi
import com.zbistapp.translator.di.*
import io.reactivex.schedulers.Schedulers
import org.koin.core.context.startKoin
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(retrofitModule, networkModule, viewModelModule))
        }
    }
}