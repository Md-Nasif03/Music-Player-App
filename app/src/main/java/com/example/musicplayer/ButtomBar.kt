package com.example.musicplayer

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ButtomBar(viewModel: MainViewModel){
    if (viewModel.currentScreen is Screen || viewModel.currentScreen.value== Screen.Home ){
        BottomNavigation(Modifier.wrapContentSize()) {

        }
    }
}