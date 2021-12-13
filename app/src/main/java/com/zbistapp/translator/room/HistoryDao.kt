package com.zbistapp.translator.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Query("SELECT * FROM HistoryTable")
    fun getHistory(): List<HistoryRoomEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun addToHistory(entity: HistoryRoomEntity)

    @Query("DELETE FROM HistoryTable")
     fun clearHistory()
}