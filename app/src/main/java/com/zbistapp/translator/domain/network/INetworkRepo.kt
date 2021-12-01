package com.zbistapp.translator.domain.network

import com.zbistapp.translator.domain.entities.MainEntity
import io.reactivex.Single

interface INetworkRepo {

    fun fetchWords(word: String): Single<List<MainEntity>>
}