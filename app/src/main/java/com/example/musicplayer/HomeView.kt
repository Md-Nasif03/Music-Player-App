package com.example.musicplayer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.musicplayer.ui.theme.MusicPlayerTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeView(){
    val scaffoldState:ScaffoldState= rememberScaffoldState()
    val scope:CoroutineScope= rememberCoroutineScope()

    val controller:NavController= rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val title = remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Home", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Menu",
                            tint = Color.White
                        )
                    }
                },
                backgroundColor = Color.Red,
                elevation = 3.dp
            )
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            LazyColumn(
                modifier = Modifier.padding(15.dp)
            ) {
                items(screensInDrawer){item->
                    DrawerItem(selected = currentRoute==item.route, item = item) {
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                        if (item.route=="add_account"){
                            //open dialog
                        }else{
                            controller.navigate(item.route)
                            title.value=item.title
                        }
                    }
                    
                }
            }
        }

    ) {
        Text(text = "Home",
            modifier = Modifier.padding(it)
            )
    }
}


@Composable
fun DrawerItem(
    selected:Boolean,
    item:Screen,
    onDrawerItemClicked: ()->Unit
){
    val background = if (selected) Color.Gray else colorResource(id = R.color.white)
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(background)
            .clickable { onDrawerItemClicked() }
    ){
        item.icon?.let { painterResource(id = it) }
            ?.let { Icon(painter = it, contentDescription = item.title,Modifier.padding(end = 10.dp)) }
        Text(text = item.title, style = MaterialTheme.typography.bodyLarge)
    }
}


@Preview(showBackground = true)
@Composable
fun HomeViewPreview() {
    MusicPlayerTheme {
        HomeView()
    }
}