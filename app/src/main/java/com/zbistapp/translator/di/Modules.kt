package com.zbistapp.translator.di

import androidx.room.Room
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.zbistapp.translator.data.LocalRepoImpl
import com.zbistapp.translator.data.NetworkRepoImpl
import com.zbistapp.translator.data.TranslatorApi
import com.zbistapp.translator.domain.local.ILocalRepo
import com.zbistapp.translator.domain.network.INetworkRepo
import com.zbistapp.translator.room.HistoryDao
import com.zbistapp.translator.room.HistoryDatabase
import com.zbistapp.translator.ui.history.HistoryViewModel
import com.zbistapp.translator.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://dictionary.skyeng.ru/api/public/v1/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<TranslatorApi> { get<Retrofit>().create(TranslatorApi::class.java) }
}

val roomModule = module {

    single<HistoryDao> {
        Room.databaseBuilder(
            get(),
            HistoryDatabase::class.java,
            "history.db"
        )
            .allowMainThreadQueries()
            .build()
            .historyDao()
    }
}

val repoModule = module {

    single<INetworkRepo> { NetworkRepoImpl(translatorApi = get()) }
    single<ILocalRepo> { LocalRepoImpl(historyDao = get()) }
}

val viewModelModule = module {

    viewModel<MainViewModel> { MainViewModel(networkRepo = get(), localRepo = get()) }
    viewModel<HistoryViewModel> { HistoryViewModel(localRepo = get()) }
}