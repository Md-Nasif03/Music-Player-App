package com.example.musicplayer.Data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [AccountDetails::class],
    version = 1
)
abstract class AccountDataBase:RoomDatabase() {
    abstract fun accountDao():AccountDao
}