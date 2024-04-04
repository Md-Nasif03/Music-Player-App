package com.example.musicplayer


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.musicplayer.Data.Artist
import com.example.musicplayer.Data.MadeForYou
import com.example.musicplayer.Data.NewlyAdded
import com.example.musicplayer.Data.TopPicks
import com.example.musicplayer.ui.theme.MusicPlayerTheme
import com.example.musicplayer.Artists
import com.example.musicplayer.Data.ArtistList
import com.example.musicplayer.Data.RomanceList
import com.example.musicplayer.Data.TopPick

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavController){
    //groupBy{it[0]} sort the string according to alphabeted
    val grouped = listOf("Top Picks","Newly Added","Made For You","Subscription","Artists For you","Romance","Podcast").groupBy { it[0] }
    LazyColumn{
        /* The grouped.forEach method in Kotlin is used to iterate over a
        collection of elements that are grouped together. It takes a lambda expression as an argument,
        which is executed for each group in the collection.*/
        grouped.forEach{
            stickyHeader {
                //it stick the text
                Text(text = it.value[0],
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                    )
                // for different group different item
                if (it.value[0] == "Top Picks") {
                    LazyRow{
                            items(TopPicks) { item ->
                                BrowserItem(item)
                            }
                        }

                }else if (it.value[0] == "Newly Added") {
                    LazyRow {
                        items(NewlyAdded){
                            Romance(artist = it)
                        }
                    }
                }else if (it.value[0] == "Made For You") {
                    LazyRow {
                        items(MadeForYou){
                            Romance(artist = it)
                        }
                    }
                }else if (it.value[0] == "Subscription") {
                    SubscribeCard {
                        navController.navigate("subscription")
                    }
                }else if (it.value[0] == "Artists For you") {
                    LazyRow {
                        items(ArtistList){
                            Artists(artist = it)
                        }
                    }
                }else if (it.value[0] == "Romance") {
                    LazyRow {
                        items(RomanceList){
                            Romance(artist = it)
                        }
                    }
                }else{
                    Podcast()
                }
            }
        }
    }
}



@Composable
fun BrowserItem(
    songLibrary: TopPick
){
    Card(
        modifier = Modifier
            .padding(16.dp)
            .shadow(5.dp)
            .clip(shape = RoundedCornerShape(10))
            .wrapContentSize(),
        border = BorderStroke(2.dp, Color.Black),
        backgroundColor = Color.Red
    ){
        Image(painter = painterResource(id = songLibrary.image), contentDescription ="image", contentScale = ContentScale.Fit )
    }
}
@Composable
fun Artists(artist: Artist){
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
                .size(150.dp),
            shape = RoundedCornerShape(50),
            backgroundColor = Color.Transparent,
            border = BorderStroke(2.dp, Brush.radialGradient(listOf(Color.Red, Color.Blue, Color.Black))),
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

@Composable
fun Romance(artist: Artist){
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
                .size(150.dp),
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
@Composable
fun SubscribeCard(onClick:()->Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onClick() },
        elevation = 5.dp,
        shape = RoundedCornerShape(5),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.linearGradient(
                        listOf(
                            colorResource(id = R.color.pink),
                            colorResource(id = R.color.litepurple),
                            colorResource(id = R.color.warmred),
                            colorResource(id = R.color.darkPurple),
                            colorResource(id = R.color.litepurple)
                        )
                    )
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(text = "Your Favourite Music App",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                color = Color.White
                )
            Text(text = "Now Has All The Songs!",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                color = Color.White
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Button(onClick = { onClick() },
                shape = RoundedCornerShape(50),
                colors = ButtonColors(Color.White, Color.Black, Color.DarkGray, Color.Black)
                ) {
                Text(text = "Subscribe $299/year",
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.Serif,
                    color = Color.Black
                )
            }
            Text(text = "-- Limited Time Offer --",
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.Serif,
                color = Color.White
                )
            Text(text = "Price Going Up Soon To $499",
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.Serif,
                color = colorResource(id = R.color.SubTextColor)
            )
        }
    }
}

@Composable
fun Podcast(){
    Card(
        modifier = Modifier.fillMaxWidth().padding(10.dp),
        shape = RoundedCornerShape(10),
        elevation = 10.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.podcast),
            contentDescription ="podcast",
            contentScale = ContentScale.FillWidth
            )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MusicPlayerTheme {
        SubscribeCard (onClick = {})
    }
}


