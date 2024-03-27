package com.example.musicplayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musicplayer.ui.theme.MusicPlayerTheme
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.ui.draw.shadow


@Composable
fun AccountScreen(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 5.dp, end = 5.dp).shadow(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row (
                modifier = Modifier
                    .wrapContentSize()
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    tint = Color.White,
                    painter = painterResource(id = R.drawable.baseline_account_circle_24),
                    contentDescription = "Account"
                )
                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(5.dp)
                ) {
                    Text(
                        text = "Md Nasif",
                        color = Color.White,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif
                    )
                    Text(
                        color = Color.White,
                        text = "mdnasif03@gmail.comm",
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Thin,
                        fontFamily = FontFamily.Serif
                    )
                }
            }
            IconButton(
                onClick = { },
            ) {
                Icon(
                    tint = Color.White,
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Account Detail"
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AccountScreenPreview() {
    MusicPlayerTheme {
        AccountScreen()
    }
}