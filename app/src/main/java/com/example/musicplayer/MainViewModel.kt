package com.example.musicplayer

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicplayer.Data.AccountDetails
import com.example.musicplayer.Data.AccountGraph
import com.example.musicplayer.Data.AccountRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel(
    private var accountRepo: AccountRepo=AccountGraph.accountRepo
):ViewModel(){
    private val _currentScreen:MutableState<Screen> = mutableStateOf(Screen.Home)

    private val _openDialog =  mutableStateOf(false)
    val openDialog =_openDialog

    fun OpenDialoge(){
        _openDialog.value= true
    }


    val currentScreen:MutableState<Screen>
        get() = _currentScreen

    fun setScreen(screen: Screen){
        _currentScreen.value=screen
    }

    var name by mutableStateOf("")
    var phoneNumber by mutableStateOf("")
    var email by mutableStateOf("")

    fun nameChange(newName:String){
        name=newName
    }
    fun phoneNumberChange(newNumber:String){
        phoneNumber=newNumber
    }
    fun emailChange(newEmail:String){
        email=newEmail
    }
    fun addAccountDetail(accountDetails: AccountDetails){
        viewModelScope.launch(Dispatchers.IO) {
            accountRepo.addAccount(accountDetails)
        }
    }
    fun getAccountDetail(id:Int):Flow<AccountDetails?>{
        return accountRepo.getAccountDetail(id)
    }
}