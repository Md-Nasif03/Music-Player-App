package com.example.musicplayer

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel(){
    private val _currentScreen:MutableState<Screen> = mutableStateOf(Screen.Home)

    private val _openDialog =  mutableStateOf(false)
    val openDialog =_openDialog

    fun OpenDialoge(){
        _openDialog.value= true
    }


    val currentScreen:MutableState<Screen>
        get() = _currentScreen

    fun setCurrentScreen(screen: Screen){
        _currentScreen.value=screen
    }

}