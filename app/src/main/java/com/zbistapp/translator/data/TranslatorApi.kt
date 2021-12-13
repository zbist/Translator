package com.zbistapp.translator.data

import com.zbistapp.translator.data.entities.MainEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslatorApi {

    @GET("words/search")
    suspend fun search(@Query("search") wordToSearch: String): Response<List<MainEntity>>
}