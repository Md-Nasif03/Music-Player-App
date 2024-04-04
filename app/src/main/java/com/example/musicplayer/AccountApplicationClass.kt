package com.example.musicplayer

import android.app.Application
import com.example.musicplayer.Data.AccountGraph

class AccountApplicationClass:Application() {
    override fun onCreate() {
        super.onCreate()
        AccountGraph.provide(this)
    }
}