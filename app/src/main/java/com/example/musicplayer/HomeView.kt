package com.example.musicplayer

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.musicplayer.Data.AccountDetails
import com.example.musicplayer.ui.theme.MusicPlayerTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeView(){
    val gradient=Brush.horizontalGradient(
        colors = listOf(
            Color.Red,
            Color.Black,
            colorResource(id = R.color.purple_700)
        )
    )

    val scaffoldState:ScaffoldState= rememberScaffoldState()
    val scope:CoroutineScope= rememberCoroutineScope()
    val viewModel:MainViewModel = viewModel()

    val accountDetails=viewModel.getAccountDetail(1).collectAsState(initial = null)


    //The NavController is responsible for managing the navigation flow within the app.
    val controller:NavController= rememberNavController()
    /* A back stack entry represents a single destination in the back stack of a NavController.
    The back stack is a data structure that keeps track of the screens that the user has visited in
     a hierarchical manner. */
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    //This line extracts the route of the current destination from the navBackStackEntry.
    // it track the current route
    val currentRoute = navBackStackEntry?.destination?.route



    //Bottom bar
    val bottomBar:@Composable ()->Unit ={
        // condition for when bottom bar will show
        if ( viewModel.currentScreen.value in screensInDrawer || viewModel.currentScreen.value in screenInBottom ){
            BottomNavigation(
                modifier = Modifier.wrapContentSize(),
                backgroundColor = Color.Transparent,
                elevation = 10.dp

                ) {
                screenInBottom.forEach {item->
                    BottomNavigationItem(
                        selected = currentRoute == item.route,
                        onClick = { controller.navigate(item.route)
                                  viewModel.setScreen(item)
                                  },
                        icon = { item.icon?.let { painterResource(id = it) }
                            ?.let { Icon(painter = it, contentDescription = item.title ) } },
                        label = { Text(text = item.title)},
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.Green
                        )
                }

            }
        }
    }
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = {it != ModalBottomSheetValue.HalfExpanded}
    )
    val context= LocalContext.current
    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(5),
        sheetElevation = 4.dp,
        sheetContent = {
        //how sheet look like
        LazyColumn(
            modifier = Modifier.background(gradient)
        ){
            items(BottomSheetLayoutItems){
                MoreBottomSheet(
                    onClick = { Toast.makeText(context,"Sorry",Toast.LENGTH_SHORT).show() },
                    bottomSheetLayoutItem = it)
            }
        }
    }) {
        //Scaffold under this
        //because bottom sheet stay under this
        Scaffold(
            bottomBar = {bottomBar()},
            topBar = {
                TopAppBar(
                    title = { Text(
                        text = if (viewModel.currentScreen.value.title=="Home"){
                             if (accountDetails.value?.name==null){
                                 "Hello! Dost"
                             }else{
                                 "Hello! ${accountDetails.value?.name}"
                             }
                        }else{
                            viewModel.currentScreen.value.title
                        },
                        color = Color.White) },
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
                    //right corner
                    actions = {
                              IconButton(onClick = {
                                  scope.launch {
                                      if (modalSheetState.isVisible){
                                          modalSheetState.hide()
                                      }else{
                                          modalSheetState.show()
                                      }
                                  }
                              }) {
                                  Icon(imageVector = Icons.Default.MoreVert,
                                      contentDescription = "Bottom sheet layout",
                                      tint = Color.White
                                      )
                              }
                    },
                    backgroundColor = colorResource(id = R.color.black),
                    elevation = 3.dp
                )
            },
            scaffoldState = scaffoldState,
            drawerContent = {
                LazyColumn(
                    modifier = Modifier
                        .padding(15.dp)
                        .background(gradient)
                ) {
                    items(screensInDrawer){item->
                        DrawerItem(selected = currentRoute==item.route, item = item) {
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                            if (item.route=="add_account"){
                                // this function update the openDialog value in viewModel
                                viewModel.OpenDialoge()
                            }else{
                                controller.navigate(item.route)
                                viewModel.setScreen(item)
                            }
                        }

                    }
                }
            }

        ) {
            Box (
                modifier = Modifier.fillMaxSize()
            ){
                Image(
                    painter = painterResource(id = R.drawable.bc53745d57bab8080e975d666d5e3240),
                    contentDescription = "Background",
                    contentScale = ContentScale.FillBounds,
                    alignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Navigation(controller,viewModel = viewModel, pd =it)
            AlertDialogScreen(isOpen = viewModel.openDialog,viewModel)
        }
    }
}
//Design of bottom sheet
@Composable
fun MoreBottomSheet(onClick:()->Unit,
                    bottomSheetLayoutItem: BottomSheetLayoutItem
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        backgroundColor = Color.Transparent,
        contentColor = Color.White,
        elevation = 4.dp
    ) {
        Row (
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
            Icon(painter = painterResource(id = bottomSheetLayoutItem.icon),
                contentDescription = bottomSheetLayoutItem.title)
            Text(text = bottomSheetLayoutItem.title, modifier = Modifier.padding(start = 10.dp))
        }
    }

}
data class BottomSheetLayoutItem (
    @DrawableRes val icon:Int,
    val title:String
)
val BottomSheetLayoutItems= listOf(
    BottomSheetLayoutItem(R.drawable.baseline_settings_24,"Settings"),
    BottomSheetLayoutItem(R.drawable.baseline_share_24,"Share"),
    BottomSheetLayoutItem(R.drawable.baseline_help_24,"Help")
)



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

/*
when (viewModel.currentScreen.value) {
    Screen.Home, Screen.Profile, Screen.Settings -> {
        // Display the bottom navigation bar
    }
    else -> {
        // Do not display the bottom navigation bar
    }
}
 */


@Preview(showBackground = true)
@Composable
fun HomeViewPreview() {
    MusicPlayerTheme {
        HomeView()
    }
}

