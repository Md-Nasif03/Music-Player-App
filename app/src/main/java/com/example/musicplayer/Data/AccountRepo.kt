package com.example.musicplayer.Data

import kotlinx.coroutines.flow.Flow

class AccountRepo(
    private val accountDao: AccountDao
) {
    suspend fun addAccount(accountDetails: AccountDetails){
        accountDao.addAccount(accountDetails)
    }
    fun getAccountDetail(id:Int):Flow<AccountDetails?>{
        return accountDao.getAccountDetail(id = id )
    }
}