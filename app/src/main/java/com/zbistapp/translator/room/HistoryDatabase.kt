package com.zbistapp.translator.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [HistoryRoomEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class HistoryDatabase : RoomDatabase() {

    abstract fun historyDao(): HistoryDao
}