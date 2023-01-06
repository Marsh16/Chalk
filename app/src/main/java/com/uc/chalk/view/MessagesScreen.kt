package com.uc.chalk.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.BoxScopeInstance.align
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.uc.chalk.helper.Const
import com.uc.chalk.model.Data
import com.uc.chalk.model.Message
import com.uc.chalk.view.theme.ui.*
import com.uc.chalk.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MessagesScreen : ComponentActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setContent {
            ChalkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
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
                                val mContext = LocalContext.current
                                IconButton(
                                    onClick = {
                                        val intent = Intent(mContext, MainActivity::class.java)
                                        //intent.putExtra("username", response.username)
                                        mContext.startActivity(intent)
//                        navController.popBackStack("chat_screen", true) //add chat/group
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
                                Image(
                                    imageVector = Icons.Default.Contacts, //ganti gambar user profile
                                    contentDescription = "User Profile",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(48.dp)
                                        .clip(CircleShape)
                                        .weight(1f)
                                ) //foto temen/group
                                Text(
                                    modifier = Modifier.weight(4f),
                                    text = Const.contactnameselected, //nama temen atau group atau channel
                                    color = MaterialTheme.colorScheme.onBackground,
                                    fontFamily = firaSans,
                                    fontWeight = FontWeight.Black,
                                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                                    textAlign = TextAlign.Start,
                                )

//            ChatMessage(messages = ) //panggil list pesan disini
                            }
                            mainViewModel.getMessage(Const.contact_id)
//       mainViewModel.chat.observe(lifecycleOwner, Observer { response ->
                            // Log.e("ok", ChatList(chatlist = response).toString())
                            //ChatList(Const.chats)
//            ChatList(Const.chats)
                            for (i in Const.messages) {
                                //Log.e("contact screen", i.toString())
                                theMessage(i)
                                //Log.e("contact screen", ChatList(Const.chats).toString())
                            }

                                MessageBox()


                        }
                    }
                }
            }
//        })

        }
    }

    @Composable
    fun MessagesScreen1(picture: ImageVector, chatName: String) {
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
                    val mContext = LocalContext.current
                    IconButton(
                        onClick = {
                            val intent = Intent(mContext, MainActivity::class.java)
                            //intent.putExtra("username", response.username)
                            mContext.startActivity(intent)
//                        navController.popBackStack("chat_screen", true) //add chat/group
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
                    Image(
                        imageVector = picture,
                        contentDescription = "Chat Picture",
                        modifier = Modifier.weight(1f)
                    ) //foto temen/group
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

//
//@Composable
//fun ChatMessage(messages: List<String>) {
//    LazyColumn{
//        Modifier.padding(start = 0.dp, 10.dp)
//        items(messages.size)
//        {
//            Row(horizontalArrangement = if (messages[it] == "user_logged") Arrangement.End
//            else Arrangement.Start) {
//                theMessage(message = messages[it])
//                Spacer(modifier = Modifier.height(8.dp))
//            }
//        }
//    }
//}

    @Composable
    fun theMessage(message: Message) {
        Box(
            modifier = Modifier
//                .widthIn(max = 200.dp)
                .padding(8.dp, 8.dp)
                .border(
                    1.dp,
                    Color.Black, RoundedCornerShape(5.dp)
                )
                .fillMaxWidth()
                .background(Blue5),
            //z.background(if (message == "user_logged") Blue20 else Blue5), //kalau dari user 20, yg lain 5
            contentAlignment = Alignment.TopStart,
        ) {
            Column (modifier = Modifier.padding(16.dp)){
//                Text(
//                    text = Const.contactnameselected,
//                    fontSize = 16.sp,
//                    color = MaterialTheme.colorScheme.onBackground,
//                    fontWeight = FontWeight.Medium,
//                )

                    Text(
                        text = message.messages, //ganti jadi jam
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
//                Icon(
//                   // imageVector = if (message == "unread") Icons.Default.Done else Icons.Default.DoneAll,
//                    contentDescription = "Check Icon",
//                )

            }
        }
    }
    @Composable
    fun messageCard2(message: Message) {

//    lateinit var navController: NavController
        lateinit var navController: NavController
        val mContext = LocalContext.current
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()

        ) {

            Image(
//            icon_filled = Icons.Default.Chat,
                imageVector = Icons.Default.Contacts, //ganti gambar user profile
                contentDescription = "User Profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .weight(1f)
            )
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(3f)
                .padding(16.dp, 0.dp)

            ) {
                Text(
                    text = message.messages,//panggil username
                    modifier = Modifier
//                    .padding(0.dp, bottom = 4.dp)
                        .weight(3f),
                    maxLines = 2,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 14.sp
                )
            }

        }

    }
    @Composable
    fun MessageBox() {

        val textState = remember { mutableStateOf(TextFieldValue()) }
        val scrollState = rememberScrollState()

        Box(modifier = Modifier.background(Blue15),Alignment.BottomCenter) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()

            ) {
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
                val mContext = LocalContext.current
                FloatingActionButton(onClick = {
                    mainViewModel.postMessage(
                        textState.value.text,
                        Const.contact_id
                    )

                   finish()
                }) {
                    Icon(imageVector = Icons.Default.Send, contentDescription = null)

                }
            }
        }
    }
}