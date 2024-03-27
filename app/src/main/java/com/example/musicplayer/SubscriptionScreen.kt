package com.example.musicplayer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicplayer.ui.theme.MusicPlayerTheme

@Composable
fun SubscriptionScreen(){
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(5.dp)
            .clip(RoundedCornerShape(15.dp)),
        shape = MaterialTheme.shapes.medium,
        backgroundColor = Color.Transparent,
        contentColor = Color.White,
        border = BorderStroke(1.dp, Color.Transparent),
        elevation = 2.dp
    ) {
        Column (
            modifier = Modifier
                .padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = "Subscription Status")
                Text(text = "Expired")
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column (
                    modifier = Modifier.wrapContentSize()
                ){
                    Text(text = "Ganna + Trial")
                    Text(text = "Expired On: May14,2023",
                        fontSize = 10.sp ,
                        fontWeight = FontWeight.Light,
                        color = Color.White
                        )
                }
                Text(text = "$0.00")
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = "Re-unlock a world of limitless music!",
                    fontSize = 12.sp ,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Button(onClick = { },
                    elevation = ButtonDefaults.elevation(10.dp),
                    modifier = Modifier.clip(RoundedCornerShape(100)),
                    border = BorderStroke(1.dp, Color.Blue),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent
                    )
                    ) {
                    Text(text = "RENEW NOW")
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "See All My Transaction",
                    fontSize = 12.sp ,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "",
                        tint = Color.White
                        )
                }
            }

        }
    }
}



@Preview(showBackground = true)
@Composable
fun SubscriptionScreenPreview() {
    MusicPlayerTheme {
        SubscriptionScreen()
    }
}