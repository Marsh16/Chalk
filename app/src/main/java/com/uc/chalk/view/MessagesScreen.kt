package com.uc.chalk.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.DoneAll
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uc.chalk.view.theme.ui.Black30
import com.uc.chalk.view.theme.ui.Blue20
import com.uc.chalk.view.theme.ui.Blue5
import com.uc.chalk.view.theme.ui.firaSans

@Composable
fun MessagesScreen(picture: ImageVector, chatName: String) {
    lateinit var navController: NavController
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState(), true, null, false)
            .background(MaterialTheme.colorScheme.background)
            .padding(32.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, bottom = 8.dp)
            ) {
                IconButton(
                    onClick = {
                        navController.popBackStack("chat_screen", true) //add chat/group
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIos,
                        contentDescription = "Back Icon",
                        modifier = Modifier
                            .weight(1f),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Image(imageVector = picture, contentDescription = "Chat Picture", modifier = Modifier.weight(1f)) //foto temen/group
                Text(
                    modifier = Modifier.weight(4f),
                    text = chatName, //nama temen atau group atau channel
                    color = MaterialTheme.colorScheme.onBackground,
                    fontFamily = firaSans,
                    fontWeight = FontWeight.Black,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                    textAlign = TextAlign.Start,
                )
            }
//            ChatMessage(messages = ) //panggil list pesan disini
        }
    }
}

@Composable
fun ChatMessage(messages: List<String>) {
    LazyColumn{
        Modifier.padding(start = 0.dp, 10.dp)
        items(messages.size)
        {
            Row(horizontalArrangement = if (messages[it] == "user_logged") Arrangement.End
            else Arrangement.Start) {
                theMessage(message = messages[it])
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun theMessage(message: String) {
    Box(
        modifier = Modifier
            .widthIn(max = 200.dp)
            .background(if (message == "user_logged") Blue20 else Blue5), //kalau dari user 20, yg lain 5
        contentAlignment = Alignment.TopStart,
    ) {
        Column{
            Text(
                text = message,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(16.dp)
            )
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = message, //ganti jadi jam
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Black30
                )
                Icon(
                    imageVector = if (message == "unread") Icons.Default.Done else Icons.Default.DoneAll,
                    contentDescription = "Check Icon",
                )
            }
        }
    }
}

@Composable
fun MessageBox() {

    val textState = remember { mutableStateOf(TextFieldValue()) }
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.background(Blue5)) {
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            BasicTextField(
                value = textState.value,
                modifier = Modifier.weight(1f, true),
                onValueChange = {
                    textState.value = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Send
                )
            )
            Spacer(modifier = Modifier.size(12.dp))

            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Send, contentDescription = null)
            }
        }
    }
}