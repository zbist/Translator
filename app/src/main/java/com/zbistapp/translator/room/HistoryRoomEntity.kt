package com.zbistapp.translator.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "HistoryTable")
data class HistoryRoomEntity(
    @PrimaryKey
    @ColumnInfo(name = "word") val word: String,
)