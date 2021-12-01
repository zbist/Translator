package com.zbistapp.translator.di

import androidx.lifecycle.ViewModelProvider
import com.zbistapp.translator.data.NetworkRepoImpl
import com.zbistapp.translator.data.TranslatorApi
import com.zbistapp.translator.domain.network.INetworkRepo
import com.zbistapp.translator.ui.main.MainFragment
import com.zbistapp.translator.ui.main.MainViewModel
import com.zbistapp.translator.utils.ViewModelFactory
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://dictionary.skyeng.ru/api/public/v1/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideTranslationApi(retrofit: Retrofit): TranslatorApi =
        retrofit.create(TranslatorApi::class.java)
}

@Module
interface NetworkModule {

    @Binds
    fun bindsNetworkRepo(networkRepo: NetworkRepoImpl): INetworkRepo
}

@Module
interface ViewModelModule {

    @Binds
    fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
        RetrofitModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {

    fun inject(mainFragment: MainFragment)
}