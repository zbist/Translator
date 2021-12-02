package com.zbistapp.translator.data

import com.zbistapp.translator.domain.entities.MainEntity
import com.zbistapp.translator.domain.network.INetworkRepo

class NetworkRepoImpl(
    private val translatorApi: TranslatorApi
) : INetworkRepo {

    override suspend fun fetchWords(word: String): List<MainEntity> {
        return translatorApi.search(word)
    }
}