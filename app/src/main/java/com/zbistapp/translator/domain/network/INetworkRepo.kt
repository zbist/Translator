package com.zbistapp.translator.domain.network

import com.zbistapp.translator.domain.entities.MainEntity

interface INetworkRepo {

    suspend fun fetchWords(word: String): List<MainEntity>
}