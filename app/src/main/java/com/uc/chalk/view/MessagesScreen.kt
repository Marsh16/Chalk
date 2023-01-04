package com.uc.chalk.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
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
                Box(
                    modifier = Modifier
                        .widthIn(max = 200.dp)
                        .background(if (messages[it] == "user_logged") Blue20 else Blue5), //kalau dari user 20, yg lain 5
                    contentAlignment = Alignment.TopStart,
                ) {
                    Text(
                        text = messages[it],
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}