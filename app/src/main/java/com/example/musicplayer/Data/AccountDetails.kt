package com.example.musicplayer.Data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class AccountDetails(
    @PrimaryKey(autoGenerate = false)
    val id:Int,
    val name:String,
    val phoneNumber: Long,
    val email:String
)
