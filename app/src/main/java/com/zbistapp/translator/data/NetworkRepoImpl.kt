package com.zbistapp.translator.data

import com.zbistapp.translator.data.entities.MainEntity
import com.zbistapp.translator.domain.network.INetworkRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NetworkRepoImpl(
    private val translatorApi: TranslatorApi
) : INetworkRepo {

    override suspend fun fetchWords(word: String): Flow<List<MainEntity>> {
        return flow {
            val response = translatorApi.search(word)
            if (response.isSuccessful) {
                response.body()?.let { emit(it) }
            } else {
                throw Throwable("check internet")
            }
        }

    }
}