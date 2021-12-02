package com.zbistapp.translator.di

import com.zbistapp.translator.data.NetworkRepoImpl
import com.zbistapp.translator.data.TranslatorApi
import com.zbistapp.translator.domain.network.INetworkRepo
import com.zbistapp.translator.ui.main.MainViewModel
import io.reactivex.schedulers.Schedulers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://dictionary.skyeng.ru/api/public/v1/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<TranslatorApi> { get<Retrofit>().create(TranslatorApi::class.java) }
}

val networkModule = module {

    single<INetworkRepo> { NetworkRepoImpl(translatorApi = get()) }
}

val viewModelModule = module {

    viewModel<MainViewModel> { MainViewModel(networkRepo = get()) }
}