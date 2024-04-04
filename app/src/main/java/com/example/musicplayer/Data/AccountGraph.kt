package com.example.musicplayer.Data

import android.content.Context
import androidx.room.Room

object AccountGraph {
    private lateinit var accountDataBase: AccountDataBase

    val accountRepo by lazy {
        AccountRepo(accountDao = accountDataBase.accountDao())
    }

    fun provide(context: Context){
        accountDataBase=Room.databaseBuilder(
            context,
            AccountDataBase::class.java,
            "account_db"
        ).build()
    }
}