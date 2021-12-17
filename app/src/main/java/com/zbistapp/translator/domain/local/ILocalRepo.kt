package com.zbistapp.translator.domain.local

import com.zbistapp.translator.room.HistoryRoomEntity
import kotlinx.coroutines.flow.Flow

interface ILocalRepo {

    suspend fun fetchHistory() : Flow<List<HistoryRoomEntity>>
    suspend fun deleteHistory()
    suspend fun addToHistory(entity: HistoryRoomEntity)
}