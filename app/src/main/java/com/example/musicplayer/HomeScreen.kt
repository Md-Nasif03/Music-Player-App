package com.example.musicplayer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(){
    val categories = listOf("Hits","happy","workout","Running","TGIF")
    val categ = listOf("Hi","hap","work","Run","TG")
    //groupBy{it[0]} sort the string according to alphabeted
    val grouped = listOf("New release","Favorites","Top Rated").groupBy { it[0] }
    LazyColumn{
        /* The grouped.forEach method in Kotlin is used to iterate over a
        collection of elements that are grouped together. It takes a lambda expression as an argument,
        which is executed for each group in the collection.*/
        grouped.forEach{
            stickyHeader {
                //it stick the text
                Text(text = it.value[0], modifier = Modifier.padding(15.dp))
                // for different group different item
                if (it.value[0] == "Favorites") {
                    LazyRow {
                        items(categ) { cat ->
                            BrowserItem(text = cat)
                        }
                    }
                }else{
                    LazyRow{
                        items(categories){
                                cat->
                            BrowserItem(text = cat)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun BrowserItem(
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
fun HomeScreenPreview() {
    MusicPlayerTheme {
        HomeScreen()
    }
}