package com.zbistapp.translator.data

import com.zbistapp.translator.domain.entities.MainEntity
import com.zbistapp.translator.domain.entities.MeaningsEntity
import com.zbistapp.translator.domain.entities.TranslationEntity
import com.zbistapp.translator.domain.network.INetworkRepo
import io.reactivex.Single

class NetworkRepoImpl(
    private val translatorApi: TranslatorApi
) : INetworkRepo {

    override fun fetchWords(word: String): Single<List<MainEntity>> {
        return translatorApi.search(word)
    }
}