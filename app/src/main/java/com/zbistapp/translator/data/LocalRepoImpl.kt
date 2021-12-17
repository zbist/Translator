package com.zbistapp.translator.data

import com.zbistapp.translator.domain.local.ILocalRepo
import com.zbistapp.translator.room.HistoryDao
import com.zbistapp.translator.room.HistoryRoomEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalRepoImpl(
    private val historyDao: HistoryDao
) : ILocalRepo {

    override suspend fun fetchHistory(): Flow<List<HistoryRoomEntity>> = flow {
        emit(historyDao.getHistory())
    }


    override suspend fun deleteHistory() {
        historyDao.clearHistory()
    }

    override suspend fun addToHistory(entity: HistoryRoomEntity) {
        historyDao.addToHistory(entity)
    }
}