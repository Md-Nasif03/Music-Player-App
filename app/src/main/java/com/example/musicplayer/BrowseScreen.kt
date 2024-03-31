package com.example.musicplayer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musicplayer.ui.theme.MusicPlayerTheme

@Composable
fun BrowseScreen(){
    val categories = listOf("Hits","happy","workout","Running","TGIF","My Fvrt","Top Singer","Assamese")
    LazyVerticalGrid(columns = GridCells.Fixed(2)){
        items(categories){
            cat->
            BrowserItems(text = cat)
        }
    }
}

@Composable
fun BrowserItems(
    text:String
){
    Card(
        modifier = Modifier
            .padding(16.dp)
            .shadow(5.dp)
            .clip(shape = RoundedCornerShape(10))
            .size(200.dp),
        border = BorderStroke(2.dp, Color.Black),
        backgroundColor = Color.Red
    ){
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = text)
            Text(text = "Enjoy")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BrowseScreenPreview() {
    MusicPlayerTheme {
        BrowseScreen()
    }
}