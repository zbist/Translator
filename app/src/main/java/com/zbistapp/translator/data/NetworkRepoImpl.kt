package com.zbistapp.translator.data

import com.zbistapp.translator.domain.entities.MainEntity
import com.zbistapp.translator.domain.network.INetworkRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class NetworkRepoImpl(
    private val translatorApi: TranslatorApi
) : INetworkRepo {

    override suspend fun fetchWords(word: String): Flow<List<MainEntity>> {
        return flowOf(translatorApi.search(word))
    }

}