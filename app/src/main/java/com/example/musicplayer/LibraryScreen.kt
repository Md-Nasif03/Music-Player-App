package com.example.musicplayer

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun LibraryScreen(){
    val context = LocalContext.current
    LazyColumn{
        items(LibraryScreenItems){
            DisgnLibraryItem(libraryScreenItem = it) {
                Toast.makeText(context, "No Screen yet, Sorry",Toast.LENGTH_LONG).show()
            }
        }
    }
}

@Composable
fun DisgnLibraryItem(libraryScreenItem: LibraryScreenItem,onClick:()->Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 4.dp,
        contentColor = Color.Black,
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row {
                Icon(
                    painter = painterResource(id = libraryScreenItem.icon),
                    contentDescription = libraryScreenItem.title,
                    modifier = Modifier.padding(start = 5.dp, end = 10.dp)
                    )
                Text(text = libraryScreenItem.title)
            }
            IconButton(onClick = onClick) {
                Icon(
                    imageVector =Icons.AutoMirrored.Sharp.KeyboardArrowRight,
                    contentDescription ="Next" )
            }
        }
    }
}

data class LibraryScreenItem(
    @DrawableRes val icon:Int,
    val title:String
)

val LibraryScreenItems= listOf(
    LibraryScreenItem(R.drawable.baseline_music_note_24,"Playlist"),
    LibraryScreenItem(R.drawable.baseline_headset_mic_24,"Artist"),
    LibraryScreenItem(R.drawable.baseline_album_24,"Album")
)
