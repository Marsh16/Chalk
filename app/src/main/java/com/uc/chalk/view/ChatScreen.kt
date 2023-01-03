package com.uc.chalk.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddComment
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uc.chalk.view.theme.ui.Blue5
import com.uc.chalk.view.theme.ui.firaSans

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChatScreen() {
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
                Text(
                    modifier = Modifier.weight(5f),
                    text = "Chats",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontFamily = firaSans,
                    fontWeight = FontWeight.Black,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                    textAlign = TextAlign.Start,
                )
                IconButton(
                    onClick = {
                        navController.navigate(route = "chat_screen") //add chat/group
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.AddComment,
                        contentDescription = "Add Chat Icon",
                        modifier = Modifier
                            .graphicsLayer {
                                rotationY = 180f
                            }
                            .weight(1f),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
            tabSection(tabs = listOf("All", "Friends", "Groups"))
//            ChatCard(profileImage = , username = , chat_text = ) //pakai lazycolumn & cari tahu cara biar bisa ganti tab
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun tabSection(tabs: List<String>) { //ganti ke yg all, group, friend
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        Modifier.padding(start = 0.dp, 10.dp)
        items(tabs.size)
        {
            Box(
                modifier = Modifier
                    .padding(0.dp, 10.dp, 10.dp, 10.dp)
                    .clickable { selectedTabIndex = it }
                    .clip(RoundedCornerShape(28.dp))
                    .background(Blue5),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = tabs[it],
                    fontSize = 16.sp,
                    color = if (selectedTabIndex == it) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Black,
                    modifier = Modifier.padding(24.dp,10.dp),
                    maxLines = 1
                )
            }
        }
    }
}

@Composable
fun ChatCard(profileImage: ImageVector, username: String, chat_text: String) {
    lateinit var navController: NavController
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            imageVector = profileImage, //ganti gambar user profile
            contentDescription = "User Profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .weight(1f)
        )
        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(5f)
            .padding(16.dp, 0.dp)
        ) {
            Text(
                text = username, //panggil username
                modifier = Modifier
                    .padding(0.dp, bottom = 4.dp)
                    .weight(3f),
                maxLines = 1,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 14.sp
            )
            Text(
                text = chat_text,
                maxLines = 1,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.secondary,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}