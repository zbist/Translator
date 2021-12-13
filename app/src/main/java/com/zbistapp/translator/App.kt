package com.zbistapp.translator

import android.app.Application
import com.zbistapp.translator.data.TranslatorApi
import com.zbistapp.translator.di.AppComponent
import com.zbistapp.translator.di.DaggerAppComponent
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .build()
    }

    companion object {
        lateinit var INSTANCE: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}