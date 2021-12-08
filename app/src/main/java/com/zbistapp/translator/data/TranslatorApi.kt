package com.zbistapp.translator.data

import com.zbistapp.translator.domain.entities.MainEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslatorApi {

    @GET("words/search")
    suspend fun search(@Query("search") wordToSearch: String): List<MainEntity>
}