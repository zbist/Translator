package com.zbistapp.translator.domain.network

import com.zbistapp.translator.data.entities.MainEntity
import kotlinx.coroutines.flow.Flow

interface INetworkRepo {

    suspend fun fetchWords(word: String): Flow<List<MainEntity>>
}