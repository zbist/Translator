package com.zbistapp.translator.data

import com.zbistapp.translator.domain.entities.MainEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslatorApi {

    @GET("words/search")
    fun search(@Query("search") wordToSearch: String): Single<List<MainEntity>>
}