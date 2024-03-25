package com.example.musicplayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.example.musicplayer.ui.theme.MusicPlayerTheme

@Composable
fun AlertDialogScreen(isOpen: MutableState<Boolean>){
    if (isOpen.value){
        AlertDialog(
            onDismissRequest = {
                isOpen.value = false },
            confirmButton = {
                TextButton(onClick = {
                    isOpen.value = false
                }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton =  {
                TextButton(onClick = {
                    isOpen.value = false
                }) {
                    Text(text = "Cancel")
                }
            },
            title = {
                Text(text = "Add Account")
            },
            text = {
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    TextField(value = "",
                        onValueChange = {},
                        modifier = Modifier.padding(top = 10.dp),
                        label = { Text(text = "Email")}
                        )

                    TextField(value = "",
                        onValueChange = {},
                        modifier = Modifier.padding(top = 10.dp),
                        label = { Text(text = "Password")}
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            backgroundColor = Color.White,
            shape = RoundedCornerShape(25.dp),
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
            )
    }
}



@Preview(showBackground = true)
@Composable
fun AlertDialogScreenPreview() {
    MusicPlayerTheme {
        val isOpen = remember { mutableStateOf(true) }
        AlertDialogScreen(isOpen = isOpen )
    }
}