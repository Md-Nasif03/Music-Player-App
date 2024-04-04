package com.example.musicplayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musicplayer.Data.AccountDetails
import com.example.musicplayer.ui.theme.MusicPlayerTheme

@Composable
fun AlertDialogScreen(isOpen: MutableState<Boolean>,viewModel: MainViewModel){
    if (isOpen.value){
        AlertDialog(
            contentColor = Color.White,
            onDismissRequest = {
                isOpen.value = false },
            confirmButton = {
                TextButton(onClick = {
                    isOpen.value = false
                    viewModel.addAccountDetail(accountDetails = AccountDetails(
                        1,
                        viewModel.name,
                        viewModel.phoneNumber.toLong(),
                        viewModel.email
                    ))
                }) {
                    Text(text = "Confirm", color = Color.White)
                }
            },
            dismissButton =  {
                TextButton(onClick = {
                    isOpen.value = false
                }) {
                    Text(text = "Cancel", color = Color.White)
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
                    TextField(value = viewModel.name,
                        onValueChange = {viewModel.nameChange(it)},
                        modifier = Modifier.padding(top = 10.dp),
                        label = { Text(text = "Name", color = Color.White)}
                    )

                    TextField(value = viewModel.phoneNumber,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        onValueChange = {viewModel.phoneNumberChange(it)},
                        modifier = Modifier.padding(top = 10.dp),
                        label = { Text(text = "Phone number", color = Color.White)}
                    )

                    TextField(value = viewModel.email,
                        onValueChange = {viewModel.emailChange(it)},
                        modifier = Modifier.padding(top = 10.dp),
                        label = { Text(text = "Email", color = Color.White)}
                        )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            backgroundColor = colorResource(id = R.color.addAccount),
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
        AlertDialogScreen(isOpen = isOpen, viewModel())
    }
}