package com.example.musicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.musicplayer.ui.theme.MusicPlayerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicPlayerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeView()
                }
            }
        }
    }
}

@Composable
fun Navigation(navControl:NavController,viewModel: MainViewModel,pd:PaddingValues ){
    NavHost(navController = navControl as NavHostController , startDestination = Screen.Home.route,Modifier.padding(pd)) {
        composable(Screen.Account.route){
            AccountScreen()
        }
        composable(Screen.Subscription.route){
            SubscriptionScreen()
        }
        composable(Screen.Home.route){

        }
        composable(Screen.Library.route){

        }
        composable(Screen.Browse.route){

        }

    }
}



