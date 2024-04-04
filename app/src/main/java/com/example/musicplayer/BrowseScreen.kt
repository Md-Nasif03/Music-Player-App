package com.example.musicplayer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musicplayer.Data.Artist
import com.example.musicplayer.Data.BrowserList
import com.example.musicplayer.ui.theme.MusicPlayerTheme

@Composable
fun BrowseScreen(){
    LazyVerticalGrid(columns = GridCells.Fixed(2)){
        items(BrowserList){
            Browser(artist = it)
        }
    }
}

@Composable
fun Browser(artist: Artist){
    Column(
        modifier = Modifier
            .padding(5.dp)
            .wrapContentSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .padding(bottom = 5.dp)
                .size(185.dp),
            shape = RoundedCornerShape(10),
            backgroundColor = Color.Transparent,
            elevation = 5.dp
        ) {
            Image(
                painter = painterResource(id = artist.image),
                contentDescription ="Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(text = artist.name,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

    }
}

@Preview(showBackground = true)
@Composable
fun BrowseScreenPreview() {
    MusicPlayerTheme {
        BrowseScreen()
    }
}