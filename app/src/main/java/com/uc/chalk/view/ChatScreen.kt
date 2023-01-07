package com.uc.chalk.view

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddComment
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import com.uc.chalk.helper.Const
import com.uc.chalk.model.Chat
import com.uc.chalk.view.theme.ui.Blue20
import com.uc.chalk.view.theme.ui.Blue5
import com.uc.chalk.view.theme.ui.firaSans
//import com.uc.chalk.view.widgets.ChatCard
import com.uc.chalk.viewmodel.MainViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChatScreen(lifecycleOwner: LifecycleOwner, mainViewModel: MainViewModel) {
    lateinit var navController: NavController
    Box(
        modifier = Modifier
            .fillMaxSize()
           // .verticalScroll(state = rememberScrollState(), true)
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
                    //.verticalScroll(state = rememberScrollState(), true)
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
                val mContext = LocalContext.current
                IconButton(
                    onClick = {
                       // navController.navigate(route = "chat_screen") //add chat/group
                        val intent = Intent(mContext, NewChat::class.java)
                        //   intent.putExtra("username", response.username)
                        mContext.startActivity(intent)
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
//            tabSection(tabs = listOf("All", "Friends", "Groups","Channels"))
            tabSection(tabs = listOf("All", "Friends"))
            mainViewModel.getChat(Const.user_id)
//       mainViewModel.chat.observe(lifecycleOwner, Observer { response ->
          // Log.e("ok", ChatList(chatlist = response).toString())
           //ChatList(Const.chats)
//            ChatList(Const.chats)
            for (i in Const.chats){
                //Log.e("contact screen", i.toString())
                ChatCard2(i)
                Log.e("contact screen", ChatList(Const.chats).toString())
            }
          // ChatCard(Data(0,"a","ss","asas","sasa","saa")) //pakai lazycolumn & cari tahu cara biar bisa ganti tab
//       })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
//    ChatScreen()
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
fun ChatList(chatlist: ArrayList<Chat>) {
    LazyColumn{
        itemsIndexed(items = chatlist){index, item ->
            ChatCard2(chat = item)
            Log.e("ok","ok")
            if(  ChatCard2(chat = item) != ChatCard2(chat = item)){
                Log.e("error","should be "+ ChatCard2(chat = item))
                throw AssertionError()
            }else{
                Log.e("ok","ok")
            }
        }

    }
}

//@Composable
//fun ChatCard(data: Data) {
//    lateinit var navController: NavController
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//        //.verticalScroll(state = rememberScrollState(), true)
////            .clickable {
//////                navController.navigate("messages_screen")
////            }
//    ) {
//        Image(
//            imageVector = Icons.Default.Contacts, //ganti gambar user profile
//            contentDescription = "User Profile",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .size(48.dp)
//                .clip(CircleShape)
//                .weight(1f)
//        )
//        Column(modifier = Modifier
//            .weight(3f)
//            .padding(16.dp, 0.dp)
//        ) {
////            Text(
////                text = data.name, //panggil username
////                modifier = Modifier
////                    .padding(0.dp, bottom = 4.dp)
////                    .weight(3f),
////                maxLines = 1,
////                fontWeight = FontWeight.Bold,
////                fontFamily = FontFamily.SansSerif,
////                color = MaterialTheme.colorScheme.onBackground,
////                fontSize = 14.sp
////            )
////
//            Text(
//                text = data.name,
//                maxLines = 1,
//                fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily.SansSerif,
//                fontSize = 12.sp,
//                color = MaterialTheme.colorScheme.secondary,
//                overflow = TextOverflow.Ellipsis
//            )
//            Text(
//                text = data.phone_number,
//                maxLines = 1,
//                fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily.SansSerif,
//                fontSize = 12.sp,
//                color = MaterialTheme.colorScheme.secondary,
//                overflow = TextOverflow.Ellipsis
//            )
//        }
//    }
//}

@Composable
fun ChatCard2(chat: Chat) {

//    lateinit var navController: NavController
    lateinit var navController: NavController
    val mContext = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(30.dp)
            .padding(0.dp, bottom = 16.dp)
            .clickable {
//               navController.navigate("messages_screen")
                val intent = Intent(mContext, MessagesScreen::class.java)
              //  intent.putExtra("contactname",chat.name)
                Const.contactnameselected=chat.name
                var str = chat.contact_id

                val re = "[^A-Za-z0-9 ]".toRegex()
                str = re.replace(str, "")

                println(str)
                Const.contact_id=str
                Log.e("contact_id", Const.contact_id)
                mContext.startActivity(intent)
            }

    ) {
        Image(
//            icon_filled = Icons.Default.Chat,
            imageVector = Icons.Default.Contacts, //ganti gambar user profile
            contentDescription = "User Profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
//                .size(48.dp)
                .clip(CircleShape)
                .weight(1f)
        )
        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(4f)
            .padding(16.dp, 0.dp),
//            verticalArrangement = Arrangement.Center
        ) {
//            Text(
//                text = "Name: "+ chat.name + "\nPhone: "+ chat.phone_number, //panggil username
//                modifier = Modifier
////                    .padding(0.dp, bottom = 4.dp)
//                    .weight(4f),
//                maxLines = 2,
//                fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily.SansSerif,
//                color = MaterialTheme.colorScheme.onBackground,
//                fontSize = 14.sp
//            )
            Text(
                text = chat.name,
                maxLines = 1,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = chat.phone_number,
                maxLines = 1,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp,
                color = Blue20
            )
        }

    }

}