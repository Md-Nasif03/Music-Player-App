package com.example.musicplayer.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAccount(accountDetails: AccountDetails)

    @Query("SELECT * FROM 'AccountDetails' where id=:id")
    fun getAccountDetail (id:Int): Flow<AccountDetails?>
}